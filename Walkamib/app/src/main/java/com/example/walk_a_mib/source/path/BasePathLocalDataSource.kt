package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.path.PathOptionalFilters
import com.example.walk_a_mib.model.path.Step
import com.example.walk_a_mib.source.callback.PathCallback

abstract class BasePathLocalDataSource() {
    var pathCallback: PathCallback? = null

    abstract fun getPath(
        referenceId: String,
        destinationId: String,
        optionalFilters: PathOptionalFilters
    )
    abstract fun insertPath(referencePlace: Node, destinationId: String, steps: List<Step>)
}