
# eCommerce SOAP API

This repository contains the SOAP API development for an eCommerce site, providing essential functionalities such as managing categories, products, orders, and carts.

## Overview

The eCommerce SOAP API is designed to facilitate communication between client applications and the backend eCommerce system. It offers various endpoints for performing CRUD (Create, Read, Update, Delete) operations on different entities within the eCommerce system.

## Features

- **Category Management:** Create, retrieve, update, and delete product categories.
- **Product Management:** Add, view, update, and remove products from the catalog.
- **Order Management:** Place orders, view order details, and update order status.
- **Cart Management:** Add items to the shopping cart, update quantities, and remove items from the cart.

## Technologies Used

- **Java:** The API is implemented using Java programming language.
- **SOAP (Simple Object Access Protocol):** Communication protocol used for exchanging structured information in web services.
- **Apache CXF:** A popular SOAP web service framework for Java.
- **PostgreSQL:** Database management system used for storing eCommerce data.

## Installation

1. Clone the repository to your local machine:

    ```
    git clone https://github.com/danielkeb/webservice_eccommerce_site.git
    ```

2. Import the project into your preferred Java IDE.

3. Configure the database connection settings in the `application.properties` file.

4. Build and run the application.

## Usage

To interact with the API, you can use SOAP client tools such as SoapUI or write custom SOAP clients in your preferred programming language.

The following endpoints are available:

- `/categories`: Endpoint for managing product categories.
- `/products`: Endpoint for managing products.
- `/orders`: Endpoint for managing orders.
- `/cart`: Endpoint for managing the shopping cart.

For detailed information about the request and response formats for each endpoint, refer to the API documentation.

## Documentation

The detailed API documentation can be found in the `docs` directory of this repository. It includes information about the request and response formats for each endpoint, as well as usage examples.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or create a pull request.

