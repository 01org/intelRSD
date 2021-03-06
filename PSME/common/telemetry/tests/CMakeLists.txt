# <license_header>
#
# Copyright (c) 2017-2019 Intel Corporation
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# </license_header>

if (NOT GTEST_FOUND)
    return()
endif ()


add_gtest(telemetry telemetry
    test_runner.cpp
    telemetry_reader_mock.cpp
    telemetry_reader_test.cpp
    metrics_processor_test.cpp
    samples_processor_test.cpp
    value_rounder_test.cpp
    )

target_link_libraries(${test_target}
    telemetry
    )

add_custom_target(unittest_telemetry
    make
    )
add_custom_target(unittest_telemetry_run
    ctest --output-on-failure
    )
