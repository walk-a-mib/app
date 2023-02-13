package com.example.walk_a_mib.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import com.example.walk_a_mib.R
import com.example.walk_a_mib.model.Result
import com.example.walk_a_mib.model.user.User
import com.example.walk_a_mib.repository.user.IUserRepository
import com.example.walk_a_mib.ui.Utility.isValidEmail
import com.example.walk_a_mib.ui.Utility.isValidPasswordFormat
import com.example.walk_a_mib.ui.Utility.showSnackbarError
import com.example.walk_a_mib.util.ServiceLocator.getInstance
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private val TAG = LoginFragment::class.java.simpleName

    private var activityResultLauncher: ActivityResultLauncher<IntentSenderRequest>? = null
    private var startIntentSenderForResult: ActivityResultContracts.StartIntentSenderForResult? = null

    private var oneTapClient: SignInClient? = null
    private var signInRequest: BeginSignInRequest? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var userRepository: IUserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userRepository = getInstance()!!
            .getUserRepository(requireActivity().application)

        oneTapClient = Identity.getSignInClient(requireActivity());

        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.default_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            // Automatically sign in when exactly one credential is retrieved.
            .setAutoSelectEnabled(true)
            .build();

        startIntentSenderForResult = ActivityResultContracts.StartIntentSenderForResult()

        activityResultLauncher = registerForActivityResult(
            startIntentSenderForResult!!
        ) { activityResult: ActivityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                try {
                    val credential =
                        oneTapClient!!.getSignInCredentialFromIntent(activityResult.data)
                    val idToken = credential.googleIdToken
                    if (idToken != null) {

                        userRepository!!.getGoogleUser(idToken)
                            ?.observe(viewLifecycleOwner) { authenticationResult ->
                                if (authenticationResult != null) {
                                    if (authenticationResult.isSuccess) {
                                        val user: User =
                                            (authenticationResult as com.example.walk_a_mib.model.Result.UserResponseSuccess).data
                                    } else {
                                        showSnackbarError(requireActivity(),requireActivity().getString(R.string.error_general_auth))
                                    }
                                }
                            }
                    }
                } catch (e: ApiException) {
                    showSnackbarError(requireActivity(),requireActivity().getString(R.string.error_general_auth))
                }
            }
        }

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
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val forgotPassword = view.findViewById<TextView>(R.id.forgotPassword)

        forgotPassword.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
        }

        if (userRepository?.loggedUser != null) {
            Navigation.findNavController(requireView()).navigate(R.id.action_signInFragment_to_mainActivity)
            activity?.finish()
        }

        val email = view.findViewById<EditText>(R.id.email)
        val password = view.findViewById<EditText>(R.id.password)

        val signInGoogleBtn = view.findViewById<Button>(R.id.button_google_login)
        val signInBtn = view.findViewById<Button>(R.id.sign_in_btn)

        signInBtn.setOnClickListener {

            val emailValue = email.text.trim()
            val passwordValue = password.text.trim()

            if(emailValue.isValidEmail() and isValidPasswordFormat(passwordValue)) {
                userRepository!!.getUser(emailValue.toString(), passwordValue.toString(), true)
                    ?.observe(
                        viewLifecycleOwner
                    ) { result: Result? ->
                        if (result != null) {
                            if (result.isSuccess) {
                                val user: User =
                                    (result as com.example.walk_a_mib.model.Result.UserResponseSuccess).data

                                Log.d("SIGN-IN", "USER ${user.toString()}")
                                Navigation.findNavController(requireView()).navigate(R.id.action_signInFragment_to_mainActivity)
                            } else {
                                showSnackbarError(requireActivity(),requireActivity().getString(R.string.error_general_auth))
                            }
                        }
                    }
            } else {
                showSnackbarError(requireActivity(), requireActivity().getString(R.string.error_email_or_password_not_valid))
            }
//            activity?.finish()
        }

        signInGoogleBtn.setOnClickListener { v ->
            signInRequest?.let {
                oneTapClient!!.beginSignIn(it)
                    .addOnSuccessListener(
                        requireActivity(),
                        OnSuccessListener<BeginSignInResult> { result ->
                            Log.d(
                                TAG,
                                "onSuccess from oneTapClient.beginSignIn(BeginSignInRequest)"
                            )
                            val intentSenderRequest =
                                IntentSenderRequest.Builder(result.pendingIntent).build()
                            activityResultLauncher!!.launch(intentSenderRequest)

                            Navigation.findNavController(requireView()).navigate(R.id.action_signInFragment_to_mainActivity)
                        })
                    .addOnFailureListener(requireActivity(),
                        OnFailureListener { e -> // No saved credentials found. Launch the One Tap sign-up flow, or
                            // do nothing and continue presenting the signed-out UI.
                            showSnackbarError(requireActivity(),
                                requireActivity().getString(R.string.error_no_google_account_found_message))
                        })
            }
        }

        val signUpBtn = view.findViewById<Button>(R.id.sign_up_btn)
        signUpBtn.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}