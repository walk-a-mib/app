package com.example.demoapiarch.source.path

import com.example.demoapiarch.source.callbacks.PathCallback

abstract class BasePathRemoteDataSource() {
    var pathCallback: PathCallback? = null

    abstract fun getPath(referenceId: String, destinationId: String)
}