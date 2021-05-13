# testng-browserstack

[TestNG](http://testng.org) Integration with BrowserStack.


## Using Maven

### Setup

* Clone the repo
* Install dependencies `mvn compile`
* Update `*.conf.json` files inside the `src/test/resources/conf` directory with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)

### Running tests

- To run a single test, run `mvn test -P single`
- To run parallel tests, run `mvn test -P parallel`

## Enhancemnts
- Create wrapper functions for a few operations like findElement, waitForElementToApoear,disappear, enabled, etc. using webdriver wait to customization of that behaviour.
- Segregate element identifiers, move to the top of the class to ensure they are easily editable.
- Add page load validation to the constructure of the page object class itself.
- Add support for localization re-using developer string bundles.
- Optionally: Higlight element being interacted with using selenium hooks.  