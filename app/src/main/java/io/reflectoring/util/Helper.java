package io.reflectoring.util;

import java.util.ArrayList;
import java.util.List;

import io.reflectoring.model.Addenda;
import io.reflectoring.model.CommunicatedMutations;
import io.reflectoring.model.MainCorrespondent;
import io.reflectoring.model.ParagraphProperties;
import io.reflectoring.model.StandardAddenda;
import io.reflectoring.model.ValidDocumentRecipient;

public class Helper {
    

    public static CommunicatedMutations communicatedMutations () {
    
        CommunicatedMutations communicatedMutations = new CommunicatedMutations();
        communicatedMutations.setBusinessCase("pola.mutation.tariffplan.add.with.medicard");
        communicatedMutations.setEffectivityStartDate("2022-03-01T00:00:00Z");
        communicatedMutations.setIgnoreMutationInCommunication("false");
        communicatedMutations.setSubNumber("3");
        communicatedMutations.setLevel("INSURED_PERSON");
        communicatedMutations.setMutationHolderId("97023");
        communicatedMutations.setMutationType("add tariff plan");
        communicatedMutations.setMutationParagraph(paragraphProperties());

        return communicatedMutations;
    }


    public static ParagraphProperties paragraphProperties() {

        ParagraphProperties paragraphProperties = new ParagraphProperties();
        paragraphProperties.setCode("F0023");
        paragraphProperties.setFreeText("Wijziging van uw contract.");
        paragraphProperties.setStandardText("Wijziging van uw contract.");

        return paragraphProperties;
    }
 
    public static List<StandardAddenda> standardAddendas() {

        List<StandardAddenda> standardAddendas = new ArrayList<>();

        StandardAddenda standardAddenda = new StandardAddenda();
        standardAddenda.setAbbreviation("G.I.C. - DKV Assistance");
        standardAddenda.setAnnexTypeName("General Insurance Conditions Assitance");
        standardAddenda.setDescription("G.I.C. - DKV Assistance - 14001 - 01-03-2019");
        standardAddenda.setIncluded("true");
        standardAddenda.setStandardAnnexId("78");
        standardAddenda.setStandardAnnexTypeId("5");


        StandardAddenda standardAddenda1 = new StandardAddenda();
        standardAddenda1.setAbbreviation("G.I.C.");
        standardAddenda1.setAnnexTypeName("General Insurance Conditions");
        standardAddenda1.setDescription("G.I.C. - 11901 - 01-01-2019");
        standardAddenda1.setIncluded("true");
        standardAddenda1.setStandardAnnexId("80");
        standardAddenda1.setStandardAnnexTypeId("1");
       
         standardAddendas.add(standardAddenda);
         standardAddendas.add(standardAddenda1);

         return standardAddendas;
    }


    public static MainCorrespondent mainCorrespondent() {        

        MainCorrespondent mainCorrespondent = new MainCorrespondent();
        mainCorrespondent.setCopyBrokerChecked("false");
        mainCorrespondent.setCopyBrokerDisabled("true");
        mainCorrespondent.setRecipient("POLICY_HOLDER");
        mainCorrespondent.setSendingChannel("POST");

        return mainCorrespondent;
    }

    public static List<Addenda> addenda() {

        List<Addenda> addendas = new ArrayList<>();

        Addenda addenda = new Addenda();
        addenda.setIncludeModificationEnabled("true");
        addenda.setIncluded("true");
        addenda.setTemplateCategory("POLICY");
        addendas.add(addenda);


        
        Addenda addenda1 = new Addenda();
        addenda1.setIncludeModificationEnabled("true");
        addenda1.setIncluded("true");
        addenda1.setTemplateCategory("BILL");
        addendas.add(addenda1);


        
        Addenda addenda2 = new Addenda();
        addenda2.setIncludeModificationEnabled("true");
        addenda2.setIncluded("true");
        addenda2.setTemplateCategory("LETTER");
        addendas.add(addenda2);
        
        return addendas;
    }


    public static List<ValidDocumentRecipient> validDocumentRecipient() {

        List<ValidDocumentRecipient> validDocumentRecipients = new ArrayList<>();

        ValidDocumentRecipient validDocumentRecipient = new ValidDocumentRecipient();
        validDocumentRecipient.setDocumentRecipient("POLICY_HOLDER");
        validDocumentRecipient.setIsSelectableForCoCorrespondent("false");
        validDocumentRecipient.setIsSelectableForMainCorrespondent("true");
        validDocumentRecipient.setIsVisibleForCoCorrespondent("false");
        validDocumentRecipient.setIsSelectableForCoCorrespondent("true");
        validDocumentRecipients.add(validDocumentRecipient);


        ValidDocumentRecipient validDocumentRecipient2 = new ValidDocumentRecipient();
        validDocumentRecipient2.setDocumentRecipient("BROKER");
        validDocumentRecipient2.setIsSelectableForCoCorrespondent("false");
        validDocumentRecipient2.setIsSelectableForMainCorrespondent("true");
        validDocumentRecipient2.setIsVisibleForCoCorrespondent("false");
        validDocumentRecipient2.setIsSelectableForCoCorrespondent("true");
        validDocumentRecipients.add(validDocumentRecipient2);

        ValidDocumentRecipient validDocumentRecipient3 = new ValidDocumentRecipient();
        validDocumentRecipient3.setDocumentRecipient("NEW_BROKER");
        validDocumentRecipient3.setIsSelectableForCoCorrespondent("false");
        validDocumentRecipient3.setIsSelectableForMainCorrespondent("true");
        validDocumentRecipient3.setIsVisibleForCoCorrespondent("false");
        validDocumentRecipient3.setIsSelectableForCoCorrespondent("true");
        validDocumentRecipients.add(validDocumentRecipient3);

        ValidDocumentRecipient validDocumentRecipient4 = new ValidDocumentRecipient();
        validDocumentRecipient4.setDocumentRecipient("CORRESPONDENCE_ADDRESS");
        validDocumentRecipient4.setIsSelectableForCoCorrespondent("false");
        validDocumentRecipient4.setIsSelectableForMainCorrespondent("true");
        validDocumentRecipient4.setIsVisibleForCoCorrespondent("false");
        validDocumentRecipient4.setIsSelectableForCoCorrespondent("true");
        validDocumentRecipients.add(validDocumentRecipient4);

        return validDocumentRecipients;
    }
}
