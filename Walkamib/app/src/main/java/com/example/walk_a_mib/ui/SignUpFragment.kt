package com.example.walk_a_mib.ui

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.walk_a_mib.R
import com.example.walk_a_mib.model.user.User
import com.example.walk_a_mib.model.user.UserViewModel
import com.example.walk_a_mib.model.user.UserViewModelFactory
import com.example.walk_a_mib.repository.user.IUserRepository
import com.example.walk_a_mib.util.ServiceLocator
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var userViewModel: UserViewModel? = null
    private var userRepository: IUserRepository? = null

    fun String.isValidEmail() =
        isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userRepository = ServiceLocator.getInstance()!!.getUserRepository(requireActivity().application)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Function to validate email
        fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

        // Function to validate password
        fun isValidPasswordFormat(password: CharSequence): Boolean {
            val passwordREGEX = Pattern.compile("^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");
            return passwordREGEX.matcher(password).matches()
        }

        val signUpBtn = view.findViewById<Button>(R.id.sign_up_btn)

        signUpBtn.setOnClickListener {
            val email = view.findViewById<EditText>(R.id.email)
            val password = view.findViewById<EditText>(R.id.password)
            val confirmPassword = view.findViewById<EditText>(R.id.confirmPassword)
            val confirmPasswordContainer = view.findViewById<TextInputLayout>(R.id.confirmPasswordContainer)

            val emailValue = email.text.trim()
            val passwordValue = password.text.trim()
            val confirmPasswordValue = confirmPassword.text.trim()

            if(emailValue.isValidEmail() and isValidPasswordFormat(passwordValue)){
//                Log.d("SIGNUP", "Email: $email, Password: $password")
                if(passwordValue.toString() == confirmPasswordValue.toString()) {
                    // Perform sign up action
                    Log.d("SIGNUP", "Inviato {Email: $emailValue, Password: $passwordValue}")

                    userRepository!!.getUser(emailValue.toString(), passwordValue.toString(), false)
                        .observe(
                            viewLifecycleOwner
                        ) { result: com.example.walk_a_mib.model.Result ->
                            Log.d("SIGNUP", "${result.isSuccess}")
                            if (result.isSuccess) {
                                val user: User =
                                    (result as com.example.walk_a_mib.model.Result.UserResponseSuccess).data

                                Log.d("SIGNUP", "USER ${user.toString()}")
                            }
                        }

                    Navigation.findNavController(requireView()).navigate(R.id.action_signUpFragment_to_signInFragment)
                } else {
                    showSnackbarError("Passwords do NOT match")
                }
            } else {
                showSnackbarError("Email or Password are not valid!")
            }

        }

        val signInBtn = view.findViewById<Button>(R.id.sign_in_btn)
        signInBtn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }

    fun showSnackbarError(message: String) {
        return Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}