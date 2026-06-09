# E commerce site full automation 
## 📃 Project Summary: 
An e-commerce site, "Nop Commerce" site full automation using TestNG framework and report generation using Allure Reporting
## 🎯 Project goal:
Verify the full system workflow and check the user email intregety and workflow of 3rd party payment gateway
## 📋 Project details:
This project is an end-to-end automation testing framework developed for the NopCommerce e-commerce platform. The framework simulates a complete customer purchasing journey, starting from user registration and ending with order confirmation and logout. It validates critical business workflows while ensuring data integrity, authentication management, pricing accuracy, and successful order placement.
The automation framework is designed to mimic real-world user behavior and verify that each step of the e-commerce process functions correctly. Test data generated during registration is dynamically stored and reused throughout the execution flow, making the tests more maintainable and realistic.The automation framework is designed to mimic real-world user behavior and verify that each step of the e-commerce process functions correctly. Test data generated during registration is dynamically stored and reused throughout the execution flow, making the tests more maintainable and realistic.
### Key Features:
* Automated user registration process.
* Dynamic test data generation and storage using JSON.
* Reuse of registered user credentials for login functionality.
* Authentication token/session management to avoid repetitive logins.
* Automated navigation through the online store.
* Product selection and cart management.
* End-to-end checkout workflow automation.
* Validation of product prices and total order calculations.
* Billing address selection and verification.
* Shipping address selection and verification.
* Shipping method selection and validation.
* Payment method selection and validation.
* Order placement and confirmation verification.
* Extraction and validation of generated order numbers.
* Verification of order confirmation email notifications.
* Automated return to the homepage after successful purchase.
* Secure user logout verification.

### Automation flow
1. Register a new user account.
2. Store registration data in a JSON file.
3. Login using the stored user credentials.
4. Save and reuse authentication information for subsequent actions.
5. Browse the store and add products to the shopping cart.
6. Proceed to checkout.
7. Validate product prices, subtotals, taxes, shipping charges, and grand total calculations.
8. Select and verify billing information.
9. Select and verify shipping information.
10. Choose shipping and payment methods.
11. Place the order.
12. Capture and validate the generated order number.
13. Verify successful order placement through confirmation messages and email notifications.
14. Navigate back to the homepage.
15. Logout successfully.


## ⚙️ Technology used:
* Java TestNG framework
* Rest Assure
* Allure Reporting
* JSON
* XML


## 📰 Allure Report Screenshot:


## 📹 Full automation video:
https://github.com/user-attachments/assets/35fd6fcf-d317-47c8-8906-1a0f98480ff3





