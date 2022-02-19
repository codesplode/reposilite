package com.reposilite.auth

import com.reposilite.auth.api.AuthenticationRequest
import com.reposilite.token.api.AccessTokenDto
import com.reposilite.web.http.ErrorResponse
import panda.std.Result

interface Authenticator {

    fun authenticate(authenticationRequest: AuthenticationRequest): Result<AccessTokenDto, ErrorResponse>

    fun enabled(): Boolean

    fun realm(): String

}