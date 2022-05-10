package io.reflectoring.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.reflectoring.util.*;
import io.reflectoring.api.MutationgroupsApiDelegate;
import io.reflectoring.model.CommunicatedInspMutations;
import io.reflectoring.model.CommunicatedMutations;
import io.reflectoring.model.DocumentTypeProperties;
import io.reflectoring.model.InlineResponse200;
import io.reflectoring.model.SimpleCommunicationDocOverview;
import io.reflectoring.model.SimpleCommunicationDocOverviewValidDocumentRecipientList;
import io.reflectoring.model.Value;
import io.reflectoring.model.ValueCommunicatedDocuments;

@Service
public class PolicyUUIDelegateImpl implements MutationgroupsApiDelegate{

   @Override
   public ResponseEntity<InlineResponse200> communicationDoc(Integer mutationGroupId, String policyUUID) {
       
       InlineResponse200 inlineResponse200 = new InlineResponse200(); 
       
       Value value = new Value();
       value.setLanguage("DUTCH");
       value.setPolicyUUID(policyUUID);
       value.setTemplateCode("2.1.4.L");
       value.setTemplateName("Letter contract modification");
       value.setUseOpenBalance("false");

       ValueCommunicatedDocuments valueCommunicatedDocuments = new ValueCommunicatedDocuments();
       valueCommunicatedDocuments.setMainCorrespondent(Helper.mainCorrespondent());
       valueCommunicatedDocuments.setValidDocumentRecipientList(Helper.validDocumentRecipient());
       valueCommunicatedDocuments.setAddenda(Helper.addenda());
       valueCommunicatedDocuments.setStandardAddenda(Helper.standardAddendas());
       value.setCommunicatedDocuments(valueCommunicatedDocuments);

       List<CommunicatedInspMutations> communicatedInspMutationsList = new ArrayList<>();
       CommunicatedInspMutations communicatedInspMutations = new CommunicatedInspMutations();
       SimpleCommunicationDocOverview communicationDocOverview = new SimpleCommunicationDocOverview();
       communicationDocOverview.setMainCorrespondent(Helper.mainCorrespondent());
       SimpleCommunicationDocOverviewValidDocumentRecipientList communicationDocOverviewValidDocumentRecipientList = new SimpleCommunicationDocOverviewValidDocumentRecipientList();
       communicationDocOverviewValidDocumentRecipientList.setValidDocumentRecipient(Helper.validDocumentRecipient().get(0));
       communicationDocOverview.setValidDocumentRecipientList(communicationDocOverviewValidDocumentRecipientList);
       communicationDocOverview.setAddenda(Helper.addenda().get(0));
       communicatedInspMutationsList.add(communicatedInspMutations);
       value.setCommunicatedInspMutations(communicatedInspMutationsList);


       CommunicatedMutations communicatedMutations = Helper.communicatedMutations();
       value.setCommunicatedMutations(communicatedMutations);


       DocumentTypeProperties documentTypeProperties = new DocumentTypeProperties();
       documentTypeProperties.setFileType("Policy");
       documentTypeProperties.setPovc("Policy Administration");
       documentTypeProperties.setSubType("Health");
       value.setDocumentTypeProperties(documentTypeProperties);


       value.setParagraphConcerns(Helper.paragraphProperties());
       value.setParagraphIntroduction(Helper.paragraphProperties());
       value.setParagraphsPayment(Helper.paragraphProperties());

       inlineResponse200.setValue(value);

       return new ResponseEntity<>(inlineResponse200,HttpStatus.OK); 
   }
    
}
