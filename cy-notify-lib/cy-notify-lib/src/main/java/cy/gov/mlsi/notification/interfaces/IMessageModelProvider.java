package cy.gov.mlsi.notification.interfaces;

import java.util.Map;

/**
 *  cy.gov.mlsi.notification.interfaces.IMessageModelPreparer
 */
public interface IMessageModelProvider {

    Map<String, Object> getModel(Object sourceObject) throws Exception;

}
