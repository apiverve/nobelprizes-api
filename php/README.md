# Nobel Prizes API - PHP Package

Nobel Prizes searches laureate records by first name, last name, and award category. Each result includes the winner's full name, award year, and category, while paid plans add year filtering, motivations, and biographical details.

## Installation

Install via Composer:

```bash
composer require apiverve/nobelprizes
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Nobelprizes\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'firstname' => 'Albert',
    'lastname' => 'Einstein',
    'category' => 'Physics',
    'year' => 1921
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Nobelprizes\Client;
use APIVerve\Nobelprizes\Exceptions\APIException;
use APIVerve\Nobelprizes\Exceptions\ValidationException;

try {
    $response = $client->execute(['firstname' => 'Albert', 'lastname' => 'Einstein', 'category' => 'Physics', 'year' => 1921]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 1,
    "filteredOn": [
      "firstName",
      "lastName",
      "category",
      "year"
    ],
    "nobelPrizes": [
      {
        "firstName": "Albert",
        "lastName": "Einstein",
        "born": "1879-03-14",
        "died": "1955-04-18",
        "countryborn": "Germany",
        "countrybornCode": "DE",
        "born city": "Ulm",
        "diedCountry": "USA",
        "diedCountryCode": "US",
        "diedCity": "Princeton NJ",
        "gender": "male",
        "year": "1921",
        "category": "Physics",
        "motivation": "for his services to Theoretical Physics and especially for his discovery of the law of the photoelectric effect",
        "organization": "Kaiser-Wilhelm-Institut (now Max-Planck-Institut) für Physik",
        "organizationCity": "Berlin",
        "organizationCountry": "Germany"
      }
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/nobelprizes?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/nobelprizes?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/nobelprizes?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
