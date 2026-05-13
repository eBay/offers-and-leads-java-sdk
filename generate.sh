#!/bin/bash
set -e
echo "Generating Offers and Leads Java SDK with Kiota..."
rm -rf src/main/java/com/ebay/offersandleads/generated

echo "Generating Feed API client..."
kiota generate -l java -d specs/sell_feed_v1_oas3.yaml \
  -c FeedApiClient -n com.ebay.offersandleads.generated.feed \
  -o src/main/java/com/ebay/offersandleads/generated/feed --ebc --co

echo "Code generation complete!"
