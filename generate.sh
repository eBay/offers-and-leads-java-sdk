#!/bin/bash
set -e
echo "Generating Offers and Leads Java SDK with Kiota..."
rm -rf src/main/java/com/ebay/offersandleads/generated

echo "Generating Feed API client..."
kiota generate -l java -d specs/openapi/classified-leads.yaml \
  -c FeedApiClient -n com.ebay.offersandleads.generated.feed \
  -o src/main/java/com/ebay/offersandleads/generated/feed --ebc --co

echo "Adding license headers to generated files..."
./add-license-headers.sh ./src

echo "Code generation complete!"
