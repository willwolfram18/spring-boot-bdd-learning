Feature: Verify the product service

  Scenario: client makes call to GET product
    When the client calls /products
    Then the client receives status code of 200
    And the client receives product with name

  Scenario Outline: Client can get specific products
    When the client calls /products/<id>
    Then the client receives status code of <status>
    And the client receives product named <name>

    Examples:
      | id | status | name             |
      | 1  | 200    | "First product"  |
      | 2  | 200    | "Second product" |
      | 3  | 200    | "UNKNOWN"        |