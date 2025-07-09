# Login using Excel file with Allure Report

![Java CI](https://github.com/rezaffadillah/Login-using-Excel-file-with-Allure-Report/actions/workflows/gradle.yml/badge.svg)

🚀 This is a sample QA automation project built with:
- **Selenium WebDriver + TestNG**
- **Gradle** for build management
- **Allure Reports** for beautiful test reporting
- **Data-driven testing** with Excel files (Apache POI)
- **GitHub Actions CI** to automatically run your tests on every push

---

## 📂 Features
✅ Login test reading credentials from an Excel file  
✅ Captures **screenshots on failure** and attaches them to Allure  
✅ Logs steps to Allure with easy traceability  
✅ Runs automatically on **GitHub Actions CI**  
✅ Generates detailed Allure HTML reports locally

---

## 🚀 How to run locally
1️⃣ Clone this repo:
```bash
git clone https://github.com/rezaffadillah/Login-using-Excel-file-with-Allure-Report.git
cd Login-using-Excel-file-with-Allure-Report
```

2️⃣ Execute tests with Gradle:
```bash
./gradlew clean test
```

## 📊 How to view the Allure report
After tests run, generate the interactive report:
```bash
allure serve build/allure-results
```

This will start a local server and open your default browser with the full test dashboard.

## 🛠 Tech stack
• Java + Selenium WebDriver  
• TestNG  
• Gradle  
• Allure Reports  
• Apache POI (for reading Excel)  
• GitHub Actions (CI/CD)

```markdown
## 🔗 License
MIT — free to use & adapt.
```