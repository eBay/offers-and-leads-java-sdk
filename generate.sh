#!/usr/bin/env bash

# Copyright 2026 eBay Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -euo pipefail

echo "Generating Offers and Leads Java SDK with Kiota..."
rm -rf src/main/java/com/ebay/offersandleads/generated

echo "Generating ClassifiedLeadsApiClient..."
kiota generate -l java -d specs/openapi/classified-leads.yaml \
  -c ClassifiedLeadsApiClient -n com.ebay.offersandleads.generated.classifiedleads \
  -o src/main/java/com/ebay/offersandleads/generated/classifiedleads --ebc --co

echo "Adding license headers to generated files..."
./add-license-headers.sh ./src
echo "Code generation complete!"
