/*!
 * @brief Definition of FPGAoF Error class.
 *
 * @copyright Copyright (c) 2019 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @file fpgaof_error.hpp
 */

#pragma once



#include "agent-framework/exceptions/gami_exception.hpp"



namespace agent_framework {
namespace exceptions {

/*! @brief FPGA over fabric error exception class */
class FpgaofError final : public GamiException {
public:

    /*!
     * @brief Constructor
     *
     * @param[in] msg Error message
     */
    explicit FpgaofError(const std::string& msg) : GamiException(ErrorCode::FPGAOF, msg) {}


    FpgaofError(const FpgaofError&) = default;


    FpgaofError& operator=(const FpgaofError&) = default;


    FpgaofError(FpgaofError&&) = default;


    FpgaofError& operator=(FpgaofError&&) = default;


    /*! @brief Destructor */
    virtual ~FpgaofError();
};

}
}

