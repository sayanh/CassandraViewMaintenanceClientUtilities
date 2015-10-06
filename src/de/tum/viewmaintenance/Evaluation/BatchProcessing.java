package de.tum.viewmaintenance.Evaluation;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import de.tum.viewmaintenance.OperationsManagement.OperationsGenerator;
import de.tum.viewmaintenance.client.CassandraClientUtilities;
import de.tum.viewmaintenance.view_table_structure.Table;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by shazra on 10/4/15.
 */
public class BatchProcessing {

    private static final Logger logger = Logger.getLogger("EVALUATION");
    OperationsGenerator operationsGenerator = null;
    Table viewConfig = null;
    String ipInUse = "";

    public BatchProcessing(OperationsGenerator operationsGenerator, Table viewConfig) {
        this.operationsGenerator = operationsGenerator;
        this.viewConfig = viewConfig;
        this.ipInUse = operationsGenerator.getIpsInvolved().get(0);
    }

    public void executeView1() {
        Statement viewFetchQuery = QueryBuilder.select().all().from(viewConfig.getKeySpace(), viewConfig.getName());

        List<Row> records = CassandraClientUtilities.commandExecution(ipInUse, viewFetchQuery);

        int totalRecords = 0;

        for (Row record: records) {
            if (record.getInt("select_view2_age") > 25 ) {
                totalRecords++;
            }
        }

        logger.info("### View1 stats for " + operationsGenerator.getNumOfKeys() + " keys per node and " +
                operationsGenerator.getNumOfOperations() + " operations #### ");
        logger.info("Total records = " + totalRecords);
    }

    public void executeView2() {

    }

    public void executeView3() {

    }
    public void executeView4() {

    }
    public void executeView5() {

    }
    public void executeView6() {

    }
    public void executeView7() {

    }
    public void executeView8() {

    }

    public void executeView9() {

    }
    public void executeView10() {

    }
    public void executeView11() {

    }
    public void executeView12() {

    }

    public void executeView13() {

    }

    public void executeView14() {

    }

    public void executeView15() {

    }

}
