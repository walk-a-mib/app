package com.example.demoapiarch.source.path

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.path.Step
import com.example.demoapiarch.source.callbacks.PathCallback

abstract class BasePathLocalDataSource() {
    var pathCallback: PathCallback? = null

    abstract fun getPath(referenceId: String, destinationId: String)
    abstract fun insertPath(referencePlace: Node, destinationId: String, steps: List<Step>)
}