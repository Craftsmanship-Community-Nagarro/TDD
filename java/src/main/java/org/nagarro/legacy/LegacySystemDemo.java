package org.nagarro.legacy;

/**
 * Demonstration class showing how to use the LegacyCode system
 */
public class LegacySystemDemo {

    public static void main(String[] args) {
        // Create dependencies
        Database database = new SimpleDatabase();
        Config config = new Config();
        Logger logger = new Logger("LegacySystem");

        // Create the legacy code instance
        LegacyCode legacyCode = new LegacyCode(database, config, logger);

        logger.info("Starting legacy invoice processing system...");

        try {
            // Run the main execution
            legacyCode.execute();
            logger.info("Main execution completed successfully");

            // Run some routines
            logger.info("Running routine operations...");
            legacyCode.routine1();
            legacyCode.routine2();

            logger.info("Legacy system processing completed");

        } catch (Exception e) {
            logger.error("Error during legacy system execution", e);
        }
    }
}
