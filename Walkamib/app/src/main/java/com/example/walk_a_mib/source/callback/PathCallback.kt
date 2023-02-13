

package com.example.walk_a_mib.source.callback

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.path.PathBodyResponse
import com.example.walk_a_mib.model.path.Step
import com.example.walk_a_mib.source.MapsCallback

interface PathCallback: MapsCallback {
    fun onSuccessFromLocal(referenceId: String,
                           destinationId: String,
                           distance: Int,
                           referencePlace: Node?,
                           steps: List<Step>?)
    fun onSuccessFromRemote(apiResponse: GenericApiResponse<PathBodyResponse>,
                            lastUpdate: Long)
}