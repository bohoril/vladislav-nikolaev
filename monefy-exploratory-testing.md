**Charters**

Charter 1. Validate the welcome flow of the app.
* Validate welcome screens are displayed correctly and user is able to navigate through them
* Validate notification permission (user should be able to accept or decline)
* Subscription proposal (user should be able to accept or decline)

Charter 2. Training steps.
* Go through the training steps and explore how the app onboard new users.

Charter 3. Validate the expense addition flow.
* Click on expense button
* Change date (try with past and future)
* Validate that category cannot be selected without inputting the amount
* Input amount (try different inputs)
* Add note (try different symbols and languages)
* Choose category (try different categories)
* Validate the expense addition change total expense amount on the main screen
* Validate the expense addition change balance amount on the main screen
* Validate the expense addition change category percentage on the main screen
* Validate the expense is displayed in the operations list

Charter 4. Validate the income/deposit addition flow.
* Click on income button
* Change date (try with past and future)
* Validate that category cannot be selected without inputting the amount
* Input amount (try different inputs)
* Add note (try different symbols and languages)
* Choose category (try different categories)
* Validate the income addition change total income amount on the main screen
* Validate the income addition change balance amount on the main screen
* Validate the income is displayed in the operations list

Charter 5. Validate the expense addition via category icons.
* Click on category icon on the main screen
* Validate that category is selected by default
* Validate the same steps as in Charter 3 (user should be able to add expense via category icon)

Charter 6. Validate category addition flow (will not be covered in this exploratory testing due to payment needed).
* Click on three dots on the main screen
* Click on categories
* Add new category for expenses
* Validate user is able to add expense for the new category
* Repeat the same steps for income category

Charter 7. Validate category edition flow.
* Click on three dots on the main screen
* Click on categories
* Click on the existing expense category
* Change expense category name
* Change expense category icon (will not be covered in this exploratory testing due to payment needed)
* Validate changes are applied on the main screen
* Repeat the same steps for income category
* Open again the existing expense category
* Merge the category with another category
* Validate changes are applied on the main screen and the only second category exists
* Validate amount of two categories are merged (numbers and dates are correct)
* Repeat the same steps for income category

Charter 8. Validate category removal flow.
* Click on three dots on the main screen
* Click on categories
* Click on the existing expense category
* Remove the category clicking on the trash icon
* Validate category is removed from the main screen
* Validate all expenses from the removed category are removed as well
* Repeat the same steps for income category

Charter 9. Validate the subscription payment flow + trial period (will not be covered in this exploratory testing due to payment needed).
* Validate trial period for the subscription
* Validate different payment methods
* Buy subscription and validate premium features are available
* Try to restore the subscription

Charter 10. Validate account edition flow.
* Click on three dots on the main screen
* Click on accounts
* Choose an existing account and change different fields
* Validate changes are applied

Charter 11. Validate account addition flow.
* Click on three dots on the main screen
* Click on accounts
* Add a new account (filling all fields)
* Validate the new account is created and user can interact with it the same way as with others

Charter 12. Validate account removal flow.
* Click on three dots on the main screen
* Click on accounts
* Remove the existing account
* Validate the account is removed and all operations from the account are removed as well
* Validate the balance is updated

Charter 13. Validate the transfer flow.
* Perform transfer between two accounts
* Validate the balance is updated for both accounts
* Validate total balance is the same

Charter 14. Validate account and date change on the left sidebar.
* Change account
* Change date
* Validate all changes are applied on the main screen
* Validate all the changes are applied in the operations list

Charter 15. Validate the currencies module (will not be covered in this exploratory testing due to payment needed).

Charter 16. Validate different balance modes from the settings.
* Validate Budget mode
* Validate Carry over mode
* Validate Future recurring records mode

Charter 17. Validate language change from the settings (will not be covered in this exploratory testing due to payment needed).

Charter 18. Validate currency change from the settings.
* Change currency
* Currency symbol should be changed everywhere

Charter 19. Validate the rest settings.

Charter 20. Validate the data backup and restore flow.
* Try to create data backup
* Try to restore data from the backup
* Try to clear all data

**Findings**

Charter 2. Training steps.
* Actual outcome:
  * (Minor user experience issue) On the expense addition step, the app doesn't provide a guidance, instead, it forces user to buy a subscription.
  * (Minor bug) Tooltips cover buttons and labels, making it hard to read the content.
* Expected outcome:
  * The app provides a guidance for each step without forcing a user to buy the subscription.
  * Tooltips are displayed correctly and don't cover buttons and labels. Or at least there is a way to close them.

Charter 7 + Chapter 8. Validate category edition and removal flows.
* Actual outcome:
  * (Major bug) After removing a category, the app doesn't allow a user without subscription to create a new category. Which may lead to an empty category list.
* Expected outcome:
  * User is able to create new categories if old ones were removed or merged.

Charter 13. Validate the transfer flow.
* Actual outcome:
  * (Minor bug) When user clicks on the input field, it blocks him to change accounts. The only way is to cancel the transfer and start from scratch.
* Expected outcome:
  * User is able to change accounts at any moment.

Charter 12. Validate account removal flow.
* Actual outcome:
  * (Minor bug, because user is able to remove these transfers) After account removal, all transfers made with this account are listed in the operations list. Which may lead to confusion.
  * (Major bug) After account removal, on the main screen new categories about transfers appear and user is not able to remove them or see in the list of categories.
* Expected outcome:
  * Used should not see transfers as new categories after account removal.
  * It should be more consistent where transfers are listed. Separate list could solve the issue.

Charter 20. Validate the data backup and restore flow.
* Actual outcome:
  * (Major bug) User is not able to save backup in the google drive and the only way to cancel this operation is to close the app.
* Expected outcome:
  * User is able to save backup in the google drive and cancel the operation at any moment.

**Charters Prioritization**

| Charter                                                           | Priority |
|-------------------------------------------------------------------|----------|
| Charter 1. Validate the welcome flow of the app.                  | High     |
| Charter 2. Training steps.                                        | Minor    |
| Charter 3. Validate the expense addition flow.                    | High     |
| Charter 4. Validate the income/deposit addition flow.             | High     |
| Charter 5. Validate the expense addition via category icons.      | Medium   |
| Charter 6. Validate category addition flow.                       | Medium   |
| Charter 7. Validate category edition flow.                        | Medium   |
| Charter 8. Validate category removal flow.                        | Medium   |
| Charter 9. Validate the subscription payment flow + trial period. | High     |
| Charter 10. Validate account edition flow.                        | Medium   |
| Charter 11. Validate account addition flow.                       | Medium   |
| Charter 12. Validate account removal flow.                        | Medium   |
| Charter 13. Validate the transfer flow.                           | Medium   |
| Charter 14. Validate account and date change on the left sidebar. | Medium   |
| Charter 15. Validate the currencies module.                       | Minor    |
| Charter 16. Validate different balance modes from the settings.   | Minor    |
| Charter 17. Validate language change from the settings.           | High     |
| Charter 18. Validate currency change from the settings.           | High     |
| Charter 19. Validate the rest settings.                           | Minor    |
| Charter 20. Validate the data backup and restore flow.            | Medium   |

**Risks to Mitigate**

Risk 1. Account management risks (might be covered with sync feature).
* User is not able to create an account and restore the data.
* User is not able to use the same account on different devices.
* Synchronization should be consistent and not lead to data loss.

Risk 2. Removal risks.
* User is not able to create a new category after removing the old one.
* All removals are final and user is not able to restore them.
* After removing categories and transfers the app should be consistent.

Risk 3. Data backup and restore risks.
* User should be able to save backup in the google drive.
* Data restoring should be easy and user-friendly.
* Data restoring should be consistent, not lead to data loss and replace old data.

Risk 4. Free features risks.
* Take into account premium features and make it possible for user to use free features without blocking him at any step.

Risk 5. User experience risks.
* Tooltips should not cover buttons and labels.
* All flows should be consistent and user-friendly.
* User should be able to navigate through the app without any issues (everything is smooth).

Risk 6. Calculation risks.
* All calculations should be correct and consistent.