/*
 * Copyright (c) 2020 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.auth;

import org.junit.jupiter.api.Test;
import org.panda_lang.reposilite.ReposiliteIntegrationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenListCommandTest extends ReposiliteIntegrationTest {

    @Test
    void shouldListAllTokens() {
        TokenService tokenService = super.reposilite.getTokenService();
        tokenService.createToken("/a", "a");
        tokenService.createToken("/b", "b");

        TokenListCommand tokenListCommand = new TokenListCommand();
        assertTrue(tokenListCommand.execute(super.reposilite));
    }

}