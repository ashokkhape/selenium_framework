# selenium_framework
-This repository contains a hybrid framework desined for the testing of web applications.

-This framework makes use of Selenium webdriver and is programmed in Java.

-The repository also contains a excel workbook which has sample test cases written in it.

-More about excel workbook

--First sheet is the index sheet which lists the names of all other sheets containing test cases.

--Execution mode in the index sheet helps us in being selective w.r.t to the test cases to be executed.

--Sheets other than index sheet are the sheets containing test cases to be executed.

--Test case sheets are provided with five columns namely Keyword, Locator By, Locator Value,	Value	and Status.

---Keyword -> calls the keyword implemented in the framework

---Locator By -> locates the web element based upon value in this column e.g. name, id, css or xpath

---Locator Value -> is the name of the property variable in objectRepo.properties. objectRepo.properties is a properties file 
   in the framework folder where the actual value of locator will be assigned to a corresponding variable.

---Value -> to be provided in the located element.

-Below is the list of keywords defined in the framework
1. enterText - for entering text in the webpage field
2. clickButton - for clicking buttons on the webpage
3. clickLink - for clicking links on the webpage
4. selectDropDown - for selecting value from drop down list, provide visible text
5. selectMultiList - for selecting multiple values from listbox
6. verfiyText - for verifying text on webpage against provided in value column
7. bufferText - buffers values from webpage which can be used in later steps , used when data is dynamic
8. verifyBuffer - for verifying text on webpage against buffered text
9. clickRadioButton - for clicking radio buttons in radio box
10. clickCheckBox - for checking check box
11. switchframe - for switching to other iframe
12. switchWindow - for switching browser windows/tabs
13. takeSnapShot - for taking screenshot
14. uploadFile - for uploading file on the page
15. acceptPopup - for accepting popup
16. dismissPopup - for dismissing popup
17. writePopup - for writing to popup
18. readPopup - reads message from the popup
19. verifyPopup - verifies message in the popup

