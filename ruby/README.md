# Nobel Prizes API - Ruby Gem

Nobel Prizes searches laureate records by first name, last name, and award category. Each result includes the winner's full name, award year, and category, while paid plans add year filtering, motivations, and biographical details.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_nobelprizes'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_nobelprizes
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_nobelprizes'

# Initialize the client
client = APIVerve::Nobelprizes::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  firstname: "Albert",
  lastname: "Einstein",
  category: "Physics",
  year: 1921
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ firstname: "Albert", lastname: "Einstein", category: "Physics", year: 1921 })
  puts response["data"]
rescue APIVerve::Nobelprizes::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Nobelprizes::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Nobelprizes::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/nobelprizes?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/nobelprizes?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/nobelprizes?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
