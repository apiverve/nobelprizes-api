# Nobel Prizes API - Dart/Flutter Client

Nobel Prizes searches laureate records by first name, last name, and award category. Each result includes the winner's full name, award year, and category, while paid plans add year filtering, motivations, and biographical details.

[![pub package](https://img.shields.io/pub/v/apiverve_nobelprizes.svg)](https://pub.dev/packages/apiverve_nobelprizes)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Nobel Prizes API](https://apiverve.com/marketplace/nobelprizes?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_nobelprizes: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_nobelprizes/apiverve_nobelprizes.dart';

void main() async {
  final client = NobelprizesClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'firstname': 'Albert',
      'lastname': 'Einstein',
      'category': 'Physics',
      'year': 1921
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Nobel Prizes API](https://apiverve.com/marketplace/nobelprizes?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/nobelprizes](https://docs.apiverve.com/ref/nobelprizes?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
