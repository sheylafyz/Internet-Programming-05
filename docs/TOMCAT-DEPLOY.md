Tomcat deployment with VS Code (Tomcat for Java)

This short guide shows how to register a local Tomcat and deploy the WAR using the "Tomcat for Java" extension in VS Code, plus a manual fallback.

Prerequisites
- VS Code installed
- "Tomcat for Java" extension (by Microsoft or Adoptium community) installed
- A built WAR at `target/springhealthhub.war` (build with `mvn clean package -DskipTests`)
- Your Tomcat installation (example paths used below)

1) Register Tomcat in VS Code (Tomcat extension)
- Open Command Palette (⇧⌘P / Ctrl+Shift+P)
- Run: Tomcat: Add Tomcat Server
- Select the Tomcat install folder. Examples:
  - macOS Homebrew Tomcat 11: `/opt/homebrew/Cellar/tomcat/11.0.12/libexec`
  - Local Tomcat9 install: `/Users/<you>/tomcat9`
- After adding, the Tomcat server appears in the Tomcat view (Activity Bar)

2) Deploy WAR using the extension
- Build the WAR: `mvn clean package -DskipTests`
- In VS Code Tomcat view, right-click the Tomcat server → Add Deployment
- Pick the WAR file `target/springhealthhub.war`
- Start the server (right-click → Start) if not running. The extension will copy/deploy the WAR and show status in the Output panel.

3) Manual deploy (fallback)
- Copy WAR to Tomcat webapps and restart server. Example commands (adjust to your paths):

```bash
# build
cd /Users/sheylafayza/secj3303/projects/springhealthhub
mvn clean package -DskipTests

# copy to Tomcat 11 (Homebrew)
cp target/springhealthhub.war /opt/homebrew/Cellar/tomcat/11.0.12/libexec/webapps/

# restart Tomcat 11
/opt/homebrew/Cellar/tomcat/11.0.12/libexec/bin/shutdown.sh
sleep 2
/opt/homebrew/Cellar/tomcat/11.0.12/libexec/bin/startup.sh

# or Tomcat9 user install
cp target/springhealthhub.war /Users/<you>/tomcat9/webapps/
/Users/<you>/tomcat9/bin/shutdown.sh
sleep 2
/Users/<you>/tomcat9/bin/startup.sh
```

4) Verify in browser
- App URL: `http://localhost:8080/springhealthhub/`
- Specific endpoints tested in this project:
  - `http://localhost:8080/springhealthhub/bmi/jdbc/list`
  - `http://localhost:8080/springhealthhub/bmi/jdbc/add`

5) Troubleshooting
- "Cannot add deployment" in VS Code extension:
  - Ensure the extension is installed and the Tomcat server was added (Tomcat view shows the server).
  - Check extension Output: View → Output → select "Tomcat for Java" for error details.
  - Confirm `pom.xml` packaging is `war` and the WAR exists at `target/*.war`.
  - Permission issues: ensure VS Code user can read Tomcat folder and write to `webapps` (fix with `chown`/`chmod` if necessary).

- Tomcat shows 404 for controllers or ClassNotFoundException for Spring classes:
  - Spring 6 requires Jakarta servlet APIs — use Tomcat 11 (Jakarta) not Tomcat 9 (javax).
  - If you see `ClassNotFoundException: org.springframework.web.servlet.DispatcherServlet` — redeploy to Tomcat 11.

- JDBC/DB issues (WAR deploys but data not saved):
  - Check Tomcat logs for SQL exceptions: `logs/localhost.*.log` and `logs/catalina.*.log`.
  - Verify MySQL is running and `healthhub_db` and `bmi_record` table exist.
  - Ensure MySQL driver is present (pom has `mysql-connector-j`); check WAR `WEB-INF/lib` contains the driver JAR.
  - For connection troubleshooting, add logging in the DAO or temporarily add `Class.forName("com.mysql.cj.jdbc.Driver")` before `DriverManager.getConnection` to force driver registration.

6) Useful VS Code tips
- Use the Tomcat explorer to Start/Stop server, View logs and Manage deployments.
- If adding deployment fails, restart VS Code and try again.
- Use the Servers view (if installed) to inspect running apps and ports.

If you want, I can:
- (A) Add a `Class.forName` and improved logging in `BmiRecordJdbcDao` to capture SQL errors, or
- (B) Walk you through adding Tomcat in your VS Code step-by-step interactively.

