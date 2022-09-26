package businessLogic;

import interfaces.BusinessLogicAPI;

/**
 * Provides access to the BusinessLogicAPI.
 */
public interface BusinessLogicImplProvider extends BusinessLogicAPI {
    /**
     * Provides access to the concrete BusinessLogicAPI implementation.
     *
     * @return the concrete business logic api implementation
     */
    static BusinessLogicAPI getImplementation() {
        return new BusinessLogicAPIImpl();
    }
}
