

Kitchensink on OpenShift
=========================

This is the kitchensink JBoss quickstart app.  You can find more info @ http://www.jboss.org/jdf/quickstarts/jboss-as-quickstart/guide/KitchensinkQuickstart/

Datasources e drivers
--------------------

<datasource jndi-name="java:jboss/datasources/PostgreSQLDS"
		pool-name="PostgreSQLDS" enabled="true" use-java-context="true"
		use-ccm="true">
		<connection-url>jdbc:postgresql://localhost:5432/dev</connection-url>
		<driver>postgresql-jdbc4</driver>
		<pool>
			<flush-strategy>IdleConnections</flush-strategy>
		</pool>
		<security>
			<user-name>postgres</user-name>
			<password>admin</password>
		</security>
		<validation>
			<check-valid-connection-sql>SELECT 1</check-valid-connection-sql>
			<background-validation>true</background-validation>
			<background-validation-millis>60000</background-validation-millis>
		</validation>
</datasource>
<drivers>
	<driver name="postgresql-jdbc4" module="postgresql.jdbc" />
	<driver name="h2" module="com.h2database.h2">
		<xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
	</driver>
</drivers>


Create an account at https://www.openshift.com

Create a jbossas-7 application

    rhc app create kitchensink jbossas-7 --from-code git://github.com/openshift/kitchensink-example.git

That's it, you can now checkout your application at:

    http://kitchensink-$namespace.rhcloud.com

PostgreSQL as a backend
-----------------------
By default, this quickstart uses H2 as the backend, but you may use
PostgreSQL.

To do this, add PostgreSQL cartridge to your application:

    rhc cartridge add postgresql-8.4 -a kitchensink

Edit `src/main/resources/META-INF/persistence.xml` so that the data
source points to `java:jboss/datasources/PostgreSQLDS`:

    <jta-data-source>java:jboss/datasources/PostgreSQLDS</jta-data-source>

Commit this change, and push.
