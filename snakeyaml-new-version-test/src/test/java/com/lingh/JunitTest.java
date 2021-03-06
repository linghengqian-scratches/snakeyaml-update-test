package com.lingh;

import com.lingh.pojo.YamlEngine;
import com.lingh.pojo.YamlExecuteProcessContext;
import com.lingh.pojo.YamlExecuteProcessUnit;
import com.lingh.ssEnum.ExecuteProcessConstants;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.Collection;
import java.util.Collections;

public class JunitTest {
    @Test
    public void snakeYamlTest1() {  // Simple org.apache.shardingsphere.mode.manager.cluster.coordinator.registry.process.subscriber.ProcessRegistrySubscriberTest#assertReportExecuteProcessUnit()
        YamlExecuteProcessUnit yamlExecuteProcessUnit = new YamlExecuteProcessUnit();
        yamlExecuteProcessUnit.setUnitID("159917166");
        yamlExecuteProcessUnit.setStatus(ExecuteProcessConstants.EXECUTE_STATUS_DONE);
        Collection<YamlExecuteProcessUnit> unitStatuses = Collections.singleton(yamlExecuteProcessUnit);
        YamlExecuteProcessContext yamlExecuteProcessContext = new YamlExecuteProcessContext();
        yamlExecuteProcessContext.setUnitStatuses(unitStatuses);
        String marshal = YamlEngine.marshal(yamlExecuteProcessContext);
        System.out.println("print start-------------------------");
        System.out.println(marshal);
        System.out.println("print end-------------------------");
        YamlExecuteProcessContext unmarshal = YamlEngine.unmarshal(marshal, YamlExecuteProcessContext.class);
        System.out.println("test problem out class ---------" + unmarshal.getUnitStatuses().getClass().getName());
        for (YamlExecuteProcessUnit unit : unmarshal.getUnitStatuses()) {
            System.out.println("test problem in class ---------" + unit.getClass().getName());
            if (unit.getStatus() != ExecuteProcessConstants.EXECUTE_STATUS_DONE) {
                return;
            }
        }
    }

    @Test
    public void snakeYamlTest2() {
        String marshal = "unitStatuses: !!set\n" +
                "  ? status: EXECUTE_STATUS_DONE\n" +
                "    unitID: '159917166'\n" +
                "  : null\n";
        YamlExecuteProcessContext unmarshal = YamlEngine.unmarshal(marshal, YamlExecuteProcessContext.class);
        System.out.println("test problem out class ---------" + unmarshal.getUnitStatuses().getClass().getName());
        for (YamlExecuteProcessUnit unit : unmarshal.getUnitStatuses()) {
            System.out.println("test problem in class ---------" + unit.getClass().getName());
            if (unit.getStatus() != ExecuteProcessConstants.EXECUTE_STATUS_DONE) {
                return;
            }
        }
    }

    @Test
    public void snakeYamlTest3() {
        String marshal = "unitStatuses: !!set\n" +
                "  ? status: EXECUTE_STATUS_DONE\n" +
                "    unitID: '159917166'\n" +
                "  : null\n";
        YamlExecuteProcessContext unmarshal = new Yaml(new Constructor(YamlExecuteProcessContext.class)).loadAs(marshal,YamlExecuteProcessContext.class);
        System.out.println("test problem out class ---------" + unmarshal.getUnitStatuses().getClass().getName());
        for (YamlExecuteProcessUnit unit : unmarshal.getUnitStatuses()) {
            System.out.println("test problem in class ---------" + unit.getClass().getName());
            if (unit.getStatus() != ExecuteProcessConstants.EXECUTE_STATUS_DONE) {
                return;
            }
        }
    }

    @Test
    public void snakeYamlTest4() {
        YamlExecuteProcessUnit yamlExecuteProcessUnit = new YamlExecuteProcessUnit();
        yamlExecuteProcessUnit.setUnitID("159917166");
        yamlExecuteProcessUnit.setStatus(ExecuteProcessConstants.EXECUTE_STATUS_DONE);
        Collection<YamlExecuteProcessUnit> unitStatuses = Collections.singleton(yamlExecuteProcessUnit);
        YamlExecuteProcessContext yamlExecuteProcessContext = new YamlExecuteProcessContext();
        yamlExecuteProcessContext.setUnitStatuses(unitStatuses);
        String marshal = new Yaml().dumpAsMap(yamlExecuteProcessContext);
        YamlExecuteProcessContext unmarshal = new Yaml(new Constructor(YamlExecuteProcessContext.class)).loadAs(marshal,YamlExecuteProcessContext.class);
        System.out.println("test problem out class ---------" + unmarshal.getUnitStatuses().getClass().getName());
        for (YamlExecuteProcessUnit unit : unmarshal.getUnitStatuses()) {
            System.out.println("test problem in class ---------" + unit.getClass().getName());
            if (unit.getStatus() != ExecuteProcessConstants.EXECUTE_STATUS_DONE) {
                return;
            }
        }
    }
}
