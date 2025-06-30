package org.nagarro.legacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LegacyCode {
    private Database db;
    private Config cfg;
    private Logger log;
    private List<Invoice> invoices = new ArrayList<>();
    private Map<Integer, String> statusMap = new HashMap<>();
    private int count = 0;
    private boolean flag = false;

    public LegacyCode(Database db, Config cfg, Logger log) {
        this.db = db;
        this.cfg = cfg;
        this.log = log;
    }

    public void procInvDB_a() {
        for (int i = 0; i < 500; i++) {
            Map<String, Object> inv = db.getInvoice(i);
            if (inv != null) {
                if (inv.containsKey("amount")) {
                    Object amt = inv.get("amount");
                    if (amt instanceof Number && ((Number) amt).doubleValue() > 1000) {
                        flag = true;
                        count++;
                        invoices.add(new Invoice(i, ((Number) amt).doubleValue()));
                        try {
                            db.updateInvoiceFlag(i, true);
                        } catch (Exception e) {
                            log.error("db error");
                        }
                    } else {
                        for (int j = 0; j < 20; j++) {
                            Map<String, Object> aux = db.getAux(j);
                            if (aux != null && aux.containsKey("id")) {
                                try {
                                    db.insertLog((Integer) aux.get("id"), "checked");
                                } catch (Exception ex) {
                                    continue;
                                }
                            }
                        }
                    }
                }
            } else

            {
                for (int k = 0; k < 10; k++) {
                    try {
                        db.cleanupInvoice(k);
                    } catch (Exception ex) {
                        continue;
                    }
                }
            }
        }
    }

    public void calc() {
        for (int i = 0; i < 300; i++) {
            if (i % 2 == 0) {
                invoices.add(new Invoice(i, i * 1.5));
            } else {
                if (i % 3 == 0) {
                    statusMap.put(i, "val" + i);
                } else {
                    for (int j = 0; j < 5; j++) {
                        if (j % 2 == 1) {
                            invoices.add(new Invoice(j, j * 10.0));
                        } else {
                            try {
                                db.deleteAux(j);
                            } catch (Exception ex) {
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }

    public void insDB() {
        for (int a = 0; a < 200; a++) {
            for (int b = 0; b < 100; b++) {
                if ((a + b) % 7 == 0) {
                    count += a * b;
                }
                if (count % 5 == 0) {
                    try {
                        db.insertSummary(a, b);
                    } catch (Exception e) {
                        continue;
                    }
                } else {
                    for (int c = 0; c < 50; c++) {
                        for (int d = 0; d < 25; d++) {
                            if (c * d % 3 == 0) {
                                try {
                                    db.saveReport(c, d);
                                } catch (Exception e) {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void updCond() {
        for (int i = 0; i < 100; i++) {
            int x = i * 2;
            if (x % 4 == 0) {
                for (int j = 0; j < 10; j++) {
                    try {
                        db.updateAux(j, true);
                    } catch (Exception e) {
                        continue;
                    }
                }
            } else {
                if (i % 5 == 0) {
                    flag = !flag;
                }
            }
        }
    }

    public void execute() {
        procInvDB_a();
        calc();
        insDB();
        updCond();
    }

    public void routine1() {
        for (int i = 0; i < 50; i++) {
            updCond();
        }
    }

    public void routine2() {
        for (int i = 0; i < 75; i++) {
            calc();
        }
    }

    public void routine3() {
        for (int i = 0; i < 100; i++) {
            insDB();
        }
    }

    public void routine4() {
        for (int i = 0; i < 150; i++) {
            updCond();
        }
    }

}
