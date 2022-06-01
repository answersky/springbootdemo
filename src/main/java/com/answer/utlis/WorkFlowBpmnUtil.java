package com.answer.utlis;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.*;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/4/22 17:16
 * @className: WorkFlowBpmnUtil
 * @packageName: com.answer.utlis
 * @description:
 */
public class WorkFlowBpmnUtil {
    public static void main(String[] args) throws Exception {
//        String bpmn="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn2:definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://activiti.org/bpmn\" id=\"diagram_Process_1649500360805\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">\n  <bpmn2:process id=\"Process_1649500360805\" name=\"样品请验\" isExecutable=\"true\">\n    <extensionElements>\n      <activiti:properties xmlns:activiti=\"http://activiti.org/bpmn\">\n        <activiti:property procTodoMTOpen=\"true\" procEndMTOpen=\"true\" procRejectMTOpen=\"true\"></activiti:property>\n      </activiti:properties>\n    </extensionElements>\n    <bpmn2:startEvent id=\"Event_0726lwj\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <bpmn2:outgoing>Flow_1f917pv</bpmn2:outgoing>\n    </bpmn2:startEvent>\n    <bpmn2:userTask id=\"Activity_Drafter\" name=\"起草\" activiti:assignee=\"${wf_createrId}\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"true\" minUserCount=\"1\" transferStrategy=\"all\"></activiti:property>\n        </activiti:properties>\n      </extensionElements>\n    </bpmn2:userTask>\n    <bpmn2:sequenceFlow id=\"Flow_1f917pv\" name=\"发起\" sourceRef=\"Event_0726lwj\" targetRef=\"Activity_Drafter\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n    </bpmn2:sequenceFlow>\n    <bpmn2:userTask id=\"Activity_audit\" name=\"复核\" activiti:assignee=\"${USER_2cVNSIub}\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"false\" minUserCount=\"-1\" transferStrategy=\"all\" roleList=\"[{&quot;id&quot;:&quot;1500713747558301697&quot;,&quot;parentId&quot;:&quot;1500713442468823041&quot;,&quot;label&quot;:&quot;管理员1&quot;,&quot;children&quot;:null}]\" userList=\"[{&quot;id&quot;:&quot;1513547702896558082&quot;,&quot;parentId&quot;:&quot;7&quot;,&quot;nodeType&quot;:1,&quot;userCode&quot;:&quot;2cVNSIub&quot;,&quot;label&quot;:&quot;吴丽娟&quot;,&quot;hasSubDept&quot;:false}]\"></activiti:property>\n        </activiti:properties>\n      </extensionElements>\n      <multiInstanceLoopCharacteristics isSequential=\"false\" activiti:collection=\"USER_2cVNSIubList\" activiti:elementVariable=\"USER_2cVNSIub\">\n        <completionCondition>${nrOfInstances == nrOfCompletedInstances}</completionCondition>\n      </multiInstanceLoopCharacteristics>\n    </bpmn2:userTask>\n    <bpmn2:sequenceFlow id=\"Flow_0vo634r\" name=\"通过\" sourceRef=\"Activity_Reviewer\" targetRef=\"Activity_audit\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_0vo634r'}]]></conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:endEvent id=\"Event_end\" name=\"结束\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"></activiti:executionListener>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\"></activiti:property>\n        </activiti:properties>\n      </extensionElements>\n      <bpmn2:incoming>Flow_0t9jvzt</bpmn2:incoming>\n    </bpmn2:endEvent>\n    <bpmn2:sequenceFlow id=\"Flow_0t9jvzt\" name=\"通过\" sourceRef=\"Activity_audit\" targetRef=\"Event_end\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_0t9jvzt'}]]></conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:sequenceFlow id=\"Back_1hxj8t6\" name=\"驳回\" sourceRef=\"Activity_audit\" targetRef=\"Activity_Drafter\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Back_1hxj8t6'}]]></conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:userTask id=\"Activity_Reviewer\" name=\"审核\" activiti:assignee=\"${USER_8KNhetGY}\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"></activiti:executionListener>\n        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"></activiti:taskListener>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"false\" minUserCount=\"-1\" transferStrategy=\"all\" userList=\"[{&quot;id&quot;:&quot;1500713324415942658&quot;,&quot;parentId&quot;:&quot;3&quot;,&quot;nodeType&quot;:1,&quot;userCode&quot;:&quot;8KNhetGY&quot;,&quot;label&quot;:&quot;刘峰&quot;,&quot;hasSubDept&quot;:false}]\"></activiti:property>\n        </activiti:properties>\n      </extensionElements>\n      <multiInstanceLoopCharacteristics isSequential=\"false\" activiti:collection=\"USER_8KNhetGYList\" activiti:elementVariable=\"USER_8KNhetGY\">\n        <completionCondition>${nrOfInstances == nrOfCompletedInstances}</completionCondition>\n      </multiInstanceLoopCharacteristics>\n    </bpmn2:userTask>\n    <bpmn2:sequenceFlow id=\"Flow_1t3qcis\" name=\"提交\" sourceRef=\"Activity_Drafter\" targetRef=\"Activity_Reviewer\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_1t3qcis'}]]></conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:sequenceFlow id=\"Back_04cr39y\" name=\"驳回\" sourceRef=\"Activity_Reviewer\" targetRef=\"Activity_Drafter\">\n      <extensionElements>\n        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"></activiti:executionListener>\n      </extensionElements>\n      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Back_04cr39y'}]]></conditionExpression>\n    </bpmn2:sequenceFlow>\n  </bpmn2:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_Process_1649500360805\">\n    <bpmndi:BPMNPlane bpmnElement=\"Process_1649500360805\" id=\"BPMNPlane_Process_1649500360805\">\n      <bpmndi:BPMNShape bpmnElement=\"Event_0726lwj\" id=\"BPMNShape_Event_0726lwj\">\n        <omgdc:Bounds height=\"36.0\" width=\"36.0\" x=\"222.0\" y=\"292.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"Activity_Drafter\" id=\"BPMNShape_Activity_Drafter\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"310.0\" y=\"270.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"Activity_audit\" id=\"BPMNShape_Activity_audit\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"740.0\" y=\"270.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"Event_end\" id=\"BPMNShape_Event_end\">\n        <omgdc:Bounds height=\"36.0\" width=\"36.0\" x=\"1002.0\" y=\"292.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"Activity_Reviewer\" id=\"BPMNShape_Activity_Reviewer\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"510.0\" y=\"270.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"Back_04cr39y\" id=\"BPMNEdge_Back_04cr39y\">\n        <omgdi:waypoint x=\"560.0\" y=\"270.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"560.0\" y=\"210.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"360.0\" y=\"210.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"360.0\" y=\"270.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"21.0\" x=\"450.0\" y=\"192.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"Flow_1t3qcis\" id=\"BPMNEdge_Flow_1t3qcis\">\n        <omgdi:waypoint x=\"410.0\" y=\"310.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"510.0\" y=\"310.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"449.0\" y=\"292.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"Back_1hxj8t6\" id=\"BPMNEdge_Back_1hxj8t6\">\n        <omgdi:waypoint x=\"790.0\" y=\"350.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"790.0\" y=\"420.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"360.0\" y=\"420.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"360.0\" y=\"350.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"21.0\" x=\"566.0\" y=\"402.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"Flow_0t9jvzt\" id=\"BPMNEdge_Flow_0t9jvzt\">\n        <omgdi:waypoint x=\"840.0\" y=\"310.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"1002.0\" y=\"310.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"910.0\" y=\"292.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"Flow_0vo634r\" id=\"BPMNEdge_Flow_0vo634r\">\n        <omgdi:waypoint x=\"610.0\" y=\"310.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"740.0\" y=\"310.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"665.0\" y=\"292.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"Flow_1f917pv\" id=\"BPMNEdge_Flow_1f917pv\">\n        <omgdi:waypoint x=\"258.0\" y=\"310.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"310.0\" y=\"310.0\"></omgdi:waypoint>\n        <bpmndi:BPMNLabel>\n          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"273.0\" y=\"292.0\"></omgdc:Bounds>\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn2:definitions>";
        String bpmn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn2:definitions xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" id=\"diagram_Process_1648801577201\" targetNamespace=\"http://activiti.org/bpmn\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">\n  <bpmn2:process id=\"Process_1648801577201\" name=\"操作规程\" isExecutable=\"true\">\n    <bpmn2:extensionElements>\n      <activiti:properties xmlns:activiti=\"http://activiti.org/bpmn\">\n        <activiti:property procTodoMTOpen=\"true\" procEndMTOpen=\"true\" procRejectMTOpen=\"true\" />\n      </activiti:properties>\n    </bpmn2:extensionElements>\n    <bpmn2:startEvent id=\"Event_1yoyg7e\">\n      <bpmn2:outgoing>Flow_1jd53lh</bpmn2:outgoing>\n    </bpmn2:startEvent>\n    <bpmn2:userTask id=\"Activity_0mczc50\" name=\"起草\" activiti:assignee=\"${wf_createrId}\">\n      <bpmn2:extensionElements>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"true\" minUserCount=\"1\" transferStrategy=\"all\" />\n        </activiti:properties>\n      </bpmn2:extensionElements>\n      <bpmn2:incoming>Flow_1jd53lh</bpmn2:incoming>\n      <bpmn2:incoming>Back_0p9ra15</bpmn2:incoming>\n      <bpmn2:outgoing>Flow_09nl1ag</bpmn2:outgoing>\n    </bpmn2:userTask>\n    <bpmn2:sequenceFlow id=\"Flow_1jd53lh\" name=\"开始\" sourceRef=\"Event_1yoyg7e\" targetRef=\"Activity_0mczc50\" />\n    <bpmn2:userTask id=\"Activity_05haiwx\" name=\"审核\" activiti:assignee=\"${USER_W644twbx_9sKvrv30}\">\n      <bpmn2:extensionElements>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"false\" minUserCount=\"-1\" transferStrategy=\"or\" userList=\"[{&#34;id&#34;:&#34;1500722096781787137&#34;,&#34;parentId&#34;:&#34;3&#34;,&#34;nodeType&#34;:1,&#34;userCode&#34;:&#34;W644twbx&#34;,&#34;label&#34;:&#34;王科&#34;,&#34;hasSubDept&#34;:false},{&#34;id&#34;:&#34;1526734172750614530&#34;,&#34;parentId&#34;:&#34;3&#34;,&#34;nodeType&#34;:1,&#34;userCode&#34;:&#34;9sKvrv30&#34;,&#34;label&#34;:&#34;刘阳&#34;,&#34;hasSubDept&#34;:false}]\" />\n        </activiti:properties>\n      </bpmn2:extensionElements>\n      <bpmn2:incoming>Flow_09nl1ag</bpmn2:incoming>\n      <bpmn2:outgoing>Flow_02xpe5u</bpmn2:outgoing>\n      <bpmn2:outgoing>Back_0p9ra15</bpmn2:outgoing>\n      <bpmn2:multiInstanceLoopCharacteristics activiti:collection=\"USER_W644twbx_9sKvrv30List\" activiti:elementVariable=\"USER_W644twbx_9sKvrv30\">\n        <bpmn2:completionCondition xsi:type=\"bpmn2:tFormalExpression\">${nrOfCompletedInstances == 1}</bpmn2:completionCondition>\n      </bpmn2:multiInstanceLoopCharacteristics>\n    </bpmn2:userTask>\n    <bpmn2:sequenceFlow id=\"Flow_09nl1ag\" name=\"提交\" sourceRef=\"Activity_0mczc50\" targetRef=\"Activity_05haiwx\">\n      <bpmn2:conditionExpression xsi:type=\"bpmn2:tFormalExpression\">${action == 'Flow_09nl1ag'}</bpmn2:conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:endEvent id=\"Event_0379yty\" name=\"结束\">\n      <bpmn2:extensionElements>\n        <activiti:properties>\n          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" />\n        </activiti:properties>\n      </bpmn2:extensionElements>\n      <bpmn2:incoming>Flow_02xpe5u</bpmn2:incoming>\n    </bpmn2:endEvent>\n    <bpmn2:sequenceFlow id=\"Flow_02xpe5u\" name=\"通过\" sourceRef=\"Activity_05haiwx\" targetRef=\"Event_0379yty\">\n      <bpmn2:conditionExpression xsi:type=\"bpmn2:tFormalExpression\">${action == 'Flow_02xpe5u'}</bpmn2:conditionExpression>\n    </bpmn2:sequenceFlow>\n    <bpmn2:sequenceFlow id=\"Back_0p9ra15\" name=\"驳回\" sourceRef=\"Activity_05haiwx\" targetRef=\"Activity_0mczc50\">\n      <bpmn2:conditionExpression xsi:type=\"bpmn2:tFormalExpression\">${action == 'Back_0p9ra15'}</bpmn2:conditionExpression>\n    </bpmn2:sequenceFlow>\n  </bpmn2:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_Process_1648801577201\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_Process_1648801577201\" bpmnElement=\"Process_1648801577201\">\n      <bpmndi:BPMNEdge id=\"Flow_1jd53lh_di\" bpmnElement=\"Flow_1jd53lh\">\n        <di:waypoint x=\"228\" y=\"360\" />\n        <di:waypoint x=\"280\" y=\"360\" />\n        <bpmndi:BPMNLabel>\n          <dc:Bounds x=\"243\" y=\"342\" width=\"23\" height=\"14\" />\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_09nl1ag_di\" bpmnElement=\"Flow_09nl1ag\">\n        <di:waypoint x=\"380\" y=\"360\" />\n        <di:waypoint x=\"440\" y=\"360\" />\n        <bpmndi:BPMNLabel>\n          <dc:Bounds x=\"399\" y=\"342\" width=\"22\" height=\"14\" />\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_02xpe5u_di\" bpmnElement=\"Flow_02xpe5u\">\n        <di:waypoint x=\"540\" y=\"360\" />\n        <di:waypoint x=\"602\" y=\"360\" />\n        <bpmndi:BPMNLabel>\n          <dc:Bounds x=\"560\" y=\"342\" width=\"23\" height=\"14\" />\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Back_0p9ra15_di\" bpmnElement=\"Back_0p9ra15\">\n        <di:waypoint x=\"490\" y=\"400\" />\n        <di:waypoint x=\"490\" y=\"430\" />\n        <di:waypoint x=\"330\" y=\"430\" />\n        <di:waypoint x=\"330\" y=\"400\" />\n        <bpmndi:BPMNLabel>\n          <dc:Bounds x=\"400\" y=\"412\" width=\"22\" height=\"14\" />\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"BPMNShape_Event_1yoyg7e\" bpmnElement=\"Event_1yoyg7e\">\n        <dc:Bounds x=\"192\" y=\"342\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0mczc50_di\" bpmnElement=\"Activity_0mczc50\">\n        <dc:Bounds x=\"280\" y=\"320\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_05haiwx_di\" bpmnElement=\"Activity_05haiwx\">\n        <dc:Bounds x=\"440\" y=\"320\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0379yty_di\" bpmnElement=\"Event_0379yty\">\n        <dc:Bounds x=\"602\" y=\"342\" width=\"36\" height=\"36\" />\n        <bpmndi:BPMNLabel>\n          <dc:Bounds x=\"609\" y=\"385\" width=\"23\" height=\"14\" />\n        </bpmndi:BPMNLabel>\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn2:definitions>\n";

        Document document = XmlUtil.readXML(bpmn);
        NodeList value3 = XmlUtil.getNodeListByXPath("//*[name()='bpmn2:userTask']", document);
        Map<String, String> nodeInfo = new LinkedHashMap<>();
        for (int i = 0; i < value3.getLength(); i++) {
            nodeInfo.put(value3.item(i).getAttributes().getNamedItem("id").getNodeValue(), value3.item(i).getAttributes().getNamedItem("name").getNodeValue());
            System.out.println(value3.item(i).getNodeName() + "---" + value3.item(i).getAttributes().getNamedItem("id") + "---" + value3.item(i).getAttributes().getNamedItem("name"));
        }
        String nextInfo = getNextTaskInfo("Activity_Reviewer", nodeInfo);
        System.out.println(nextInfo);
    }

    private static String getNextTaskInfo(String currentNodeId, Map<String, String> nodeInfo) throws Exception {
        Set<String> keySet = nodeInfo.keySet();
        List<String> list = new ArrayList<>(keySet);
        //获取当前节点所处的位置
        int index = list.indexOf(currentNodeId);
        if (index == keySet.size() - 1) {
            throw new Exception("当前节点处于最后审核节点");
        }
        String nextNodeId = list.get(index + 1);
        return nodeInfo.get(nextNodeId);
    }
}
