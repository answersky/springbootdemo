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
        String bpmn = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<bpmn2:definitions xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://activiti.org/bpmn\" id=\"diagram_Process_1650263652570\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">  \n" +
                "  <bpmn2:process id=\"Process_1650263652570\" name=\"请验\" isExecutable=\"true\"> \n" +
                "    <extensionElements> \n" +
                "      <activiti:properties>  \n" +
                "        <activiti:property procTodoMTOpen=\"true\" procEndMTOpen=\"true\" procRejectMTOpen=\"true\"/> \n" +
                "      </activiti:properties> \n" +
                "    </extensionElements>  \n" +
                "    <bpmn2:startEvent id=\"Event_0z09p0n\" name=\"开始\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyStartEventExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <bpmn2:outgoing>Flow_0stqubw</bpmn2:outgoing> \n" +
                "    </bpmn2:startEvent>  \n" +
                "    <bpmn2:userTask id=\"Activity_1b8eadj\" name=\"起草\" activiti:assignee=\"${wf_createrId}\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:properties> \n" +
                "          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"true\" minUserCount=\"1\" transferStrategy=\"all\"/> \n" +
                "        </activiti:properties> \n" +
                "      </extensionElements> \n" +
                "    </bpmn2:userTask>  \n" +
                "    <bpmn2:sequenceFlow id=\"Flow_0stqubw\" name=\"发起\" sourceRef=\"Event_0z09p0n\" targetRef=\"Activity_1b8eadj\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements> \n" +
                "    </bpmn2:sequenceFlow>  \n" +
                "    <bpmn2:userTask id=\"Activity_Reviewer\" name=\"收样\" activiti:assignee=\"${USER_bZ1zhiW3}\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:properties> \n" +
                "          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"false\" minUserCount=\"-1\" userList=\"[{&quot;id&quot;:&quot;1514876811889881090&quot;,&quot;parentId&quot;:&quot;3&quot;,&quot;nodeType&quot;:1,&quot;userCode&quot;:&quot;bZ1zhiW3&quot;,&quot;label&quot;:&quot;刘峰&quot;,&quot;hasSubDept&quot;:false}]\" transferStrategy=\"all\"/> \n" +
                "        </activiti:properties> \n" +
                "      </extensionElements>  \n" +
                "      <multiInstanceLoopCharacteristics isSequential=\"false\" activiti:collection=\"USER_bZ1zhiW3List\" activiti:elementVariable=\"USER_bZ1zhiW3\"> \n" +
                "        <completionCondition>${nrOfInstances == nrOfCompletedInstances}</completionCondition> \n" +
                "      </multiInstanceLoopCharacteristics> \n" +
                "    </bpmn2:userTask>  \n" +
                "    <bpmn2:sequenceFlow id=\"Flow_0jslwrm\" name=\"通过\" sourceRef=\"Activity_1b8eadj\" targetRef=\"Activity_Reviewer\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_0jslwrm'}]]></conditionExpression> \n" +
                "    </bpmn2:sequenceFlow>  \n" +
                "    <bpmn2:userTask id=\"Activity_100gupv\" name=\"收样审核\" activiti:assignee=\"${USER_CpUXjHct}\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyUserTaskExecutionListener\"/>  \n" +
                "        <activiti:taskListener event=\"assignment\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"complete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:taskListener event=\"delete\" class=\"com.mdzy.platform.tech.activiti.listener.MyTaskListener\"/>  \n" +
                "        <activiti:properties> \n" +
                "          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\" startWithAssignee=\"false\" minUserCount=\"-1\" userList=\"[{&quot;id&quot;:&quot;1514877409993437185&quot;,&quot;parentId&quot;:&quot;3&quot;,&quot;nodeType&quot;:1,&quot;userCode&quot;:&quot;CpUXjHct&quot;,&quot;label&quot;:&quot;王科&quot;,&quot;hasSubDept&quot;:false}]\" transferStrategy=\"all\"/> \n" +
                "        </activiti:properties> \n" +
                "      </extensionElements>  \n" +
                "      <multiInstanceLoopCharacteristics isSequential=\"false\" activiti:collection=\"USER_CpUXjHctList\" activiti:elementVariable=\"USER_CpUXjHct\"> \n" +
                "        <completionCondition>${nrOfInstances == nrOfCompletedInstances}</completionCondition> \n" +
                "      </multiInstanceLoopCharacteristics> \n" +
                "    </bpmn2:userTask>  \n" +
                "    <bpmn2:sequenceFlow id=\"Flow_09m5p11\" name=\"通过\" sourceRef=\"Activity_Reviewer\" targetRef=\"Activity_100gupv\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_09m5p11'}]]></conditionExpression> \n" +
                "    </bpmn2:sequenceFlow>  \n" +
                "    <bpmn2:endEvent id=\"Event_10nn3bl\" name=\"结束\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MyEndEventExecutionListener\"/>  \n" +
                "        <activiti:properties> \n" +
                "          <activiti:property procMTOpen=\"true\" nodeMTOpen=\"false\"/> \n" +
                "        </activiti:properties> \n" +
                "      </extensionElements>  \n" +
                "      <bpmn2:incoming>Flow_0n74ezf</bpmn2:incoming> \n" +
                "    </bpmn2:endEvent>  \n" +
                "    <bpmn2:sequenceFlow id=\"Flow_0n74ezf\" name=\"完成\" sourceRef=\"Activity_100gupv\" targetRef=\"Event_10nn3bl\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Flow_0n74ezf'}]]></conditionExpression> \n" +
                "    </bpmn2:sequenceFlow>  \n" +
                "    <bpmn2:sequenceFlow id=\"Back_0mo3pyj\" name=\"驳回\" sourceRef=\"Activity_Reviewer\" targetRef=\"Activity_1b8eadj\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Back_0mo3pyj'}]]></conditionExpression> \n" +
                "    </bpmn2:sequenceFlow>  \n" +
                "    <bpmn2:sequenceFlow id=\"Back_040f1jf\" name=\"驳回\" sourceRef=\"Activity_100gupv\" targetRef=\"Activity_1b8eadj\"> \n" +
                "      <extensionElements> \n" +
                "        <activiti:executionListener event=\"start\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"end\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/>  \n" +
                "        <activiti:executionListener event=\"take\" class=\"com.mdzy.platform.tech.activiti.listener.MySequenceFlowExecutionListener\"/> \n" +
                "      </extensionElements>  \n" +
                "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${action == 'Back_040f1jf'}]]></conditionExpression> \n" +
                "    </bpmn2:sequenceFlow> \n" +
                "  </bpmn2:process>  \n" +
                "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_Process_1650263652570\"> \n" +
                "    <bpmndi:BPMNPlane bpmnElement=\"Process_1650263652570\" id=\"BPMNPlane_Process_1650263652570\"> \n" +
                "      <bpmndi:BPMNShape bpmnElement=\"Event_0z09p0n\" id=\"BPMNShape_Event_0z09p0n\"> \n" +
                "        <omgdc:Bounds height=\"36.0\" width=\"36.0\" x=\"282.0\" y=\"312.0\"/> \n" +
                "      </bpmndi:BPMNShape>  \n" +
                "      <bpmndi:BPMNShape bpmnElement=\"Activity_1b8eadj\" id=\"BPMNShape_Activity_1b8eadj\"> \n" +
                "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"370.0\" y=\"290.0\"/> \n" +
                "      </bpmndi:BPMNShape>  \n" +
                "      <bpmndi:BPMNShape bpmnElement=\"Activity_Reviewer\" id=\"BPMNShape_Activity_Reviewer\"> \n" +
                "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"530.0\" y=\"290.0\"/> \n" +
                "      </bpmndi:BPMNShape>  \n" +
                "      <bpmndi:BPMNShape bpmnElement=\"Activity_100gupv\" id=\"BPMNShape_Activity_100gupv\"> \n" +
                "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"690.0\" y=\"290.0\"/> \n" +
                "      </bpmndi:BPMNShape>  \n" +
                "      <bpmndi:BPMNShape bpmnElement=\"Event_10nn3bl\" id=\"BPMNShape_Event_10nn3bl\"> \n" +
                "        <omgdc:Bounds height=\"36.0\" width=\"36.0\" x=\"852.0\" y=\"312.0\"/> \n" +
                "      </bpmndi:BPMNShape>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Back_040f1jf\" id=\"BPMNEdge_Back_040f1jf\"> \n" +
                "        <omgdi:waypoint x=\"740.0\" y=\"290.0\"/>  \n" +
                "        <omgdi:waypoint x=\"740.0\" y=\"220.0\"/>  \n" +
                "        <omgdi:waypoint x=\"420.0\" y=\"220.0\"/>  \n" +
                "        <omgdi:waypoint x=\"420.0\" y=\"290.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"21.0\" x=\"570.0\" y=\"202.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Back_0mo3pyj\" id=\"BPMNEdge_Back_0mo3pyj\"> \n" +
                "        <omgdi:waypoint x=\"580.0\" y=\"370.0\"/>  \n" +
                "        <omgdi:waypoint x=\"580.0\" y=\"420.0\"/>  \n" +
                "        <omgdi:waypoint x=\"420.0\" y=\"420.0\"/>  \n" +
                "        <omgdi:waypoint x=\"420.0\" y=\"370.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"21.0\" x=\"490.0\" y=\"402.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Flow_0n74ezf\" id=\"BPMNEdge_Flow_0n74ezf\"> \n" +
                "        <omgdi:waypoint x=\"790.0\" y=\"330.0\"/>  \n" +
                "        <omgdi:waypoint x=\"852.0\" y=\"330.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"810.0\" y=\"312.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Flow_09m5p11\" id=\"BPMNEdge_Flow_09m5p11\"> \n" +
                "        <omgdi:waypoint x=\"630.0\" y=\"330.0\"/>  \n" +
                "        <omgdi:waypoint x=\"690.0\" y=\"330.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"649.0\" y=\"312.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Flow_0jslwrm\" id=\"BPMNEdge_Flow_0jslwrm\"> \n" +
                "        <omgdi:waypoint x=\"470.0\" y=\"330.0\"/>  \n" +
                "        <omgdi:waypoint x=\"530.0\" y=\"330.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"489.0\" y=\"312.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge>  \n" +
                "      <bpmndi:BPMNEdge bpmnElement=\"Flow_0stqubw\" id=\"BPMNEdge_Flow_0stqubw\"> \n" +
                "        <omgdi:waypoint x=\"318.0\" y=\"330.0\"/>  \n" +
                "        <omgdi:waypoint x=\"370.0\" y=\"330.0\"/>  \n" +
                "        <bpmndi:BPMNLabel> \n" +
                "          <omgdc:Bounds height=\"14.0\" width=\"22.0\" x=\"333.0\" y=\"312.0\"/> \n" +
                "        </bpmndi:BPMNLabel> \n" +
                "      </bpmndi:BPMNEdge> \n" +
                "    </bpmndi:BPMNPlane> \n" +
                "  </bpmndi:BPMNDiagram>\n" +
                "</bpmn2:definitions>\n";

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
