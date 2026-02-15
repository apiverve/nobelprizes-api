# Nobel Prizes API - Go Client

Nobel Prizes is a simple tool for getting information on Nobel Prizes. It returns information on various Nobel Prizes.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Nobel Prizes API](https://apiverve.com/marketplace/nobelprizes?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/nobelprizes-api/go
```

---

## Configuration

Before using the Nobel Prizes API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Nobel Prizes API documentation is found here: [https://docs.apiverve.com/ref/nobelprizes](https://docs.apiverve.com/ref/nobelprizes?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/nobelprizes-api/go"
)

func main() {
    // Create a new client
    client := nobelprizes.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "firstname": "Albert",
        "lastname": "Einstein",
        "category": "Physics",
        "year": 1921
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
