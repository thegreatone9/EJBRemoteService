import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class TextApplication {

    /***
     * Before running, make sure to add an application user to the Wildfly server,
     * using the add-user.sh script in wildfly/bin
     */
    public static void main(String[] args) throws NamingException {
        TextProcessorRemote textProcessor = EJBFactory.createTextProcessorBeanFromJNDI("java:");
        System.out.print(textProcessor.processText("sample text"));
    }

    private static class EJBFactory {

        private static TextProcessorRemote createTextProcessorBeanFromJNDI(String namespace)
                throws NamingException {
            return lookupTextProcessorBean(namespace);
        }

        private static TextProcessorRemote lookupTextProcessorBean(String namespace) throws NamingException {
            Context ctx = createInitialContext();

            String appName = "";
            String moduleName = "EJBRemote";
            String distinctName = "";
            String beanName = "TextProcessorBean";
            String viewClassName = TextProcessorRemote.class.getName();

            return (TextProcessorRemote) ctx.lookup(namespace
                    + appName + "/" + moduleName
                    + "/" + distinctName + beanName + "!" + viewClassName);
        }

        private static Context createInitialContext() throws NamingException {
            Properties jndiProperties = new Properties();

            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "user");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "password");

            return new InitialContext(jndiProperties);
        }
    }
}