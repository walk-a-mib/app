package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.source.callback.PathCallback

abstract class BasePathRemoteDataSource() {
    var pathCallback: PathCallback? = null

    abstract fun getPath(referenceId: String, destinationId: String, accessibility: Boolean)
}