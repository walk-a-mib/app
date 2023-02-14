package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.path.Step
import com.example.walk_a_mib.source.callback.PathCallback

abstract class BasePathLocalDataSource() {
    var pathCallback: PathCallback? = null

<<<<<<< HEAD
    abstract fun getPath(
        referenceId: String,
        destinationId: String,
        accessibility: Boolean
    )
    abstract fun insertPath(
        referencePlace: Node,
        destinationId: String,
        accessibility: Boolean,
        steps: List<Step>
    )
=======
    abstract fun getPath(referenceId: String, destinationId: String)
    abstract fun insertPath(referencePlace: Node, destinationId: String, steps: List<Step>)
>>>>>>> parent of 4f9128be (aggiunto filtro)
}