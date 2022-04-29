package io.reflectoring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.reflectoring.api.CommunicationApiDelegate;
import io.reflectoring.model.Communication;
import io.reflectoring.model.Value;

@Service
public class CommunicationDocImpl implements CommunicationApiDelegate{


    @Override
    public ResponseEntity<Void> communicationDoc(Communication communication) {

        Communication communicationResponseObj = new Communication();
        
        Value value = new Value(); 
        value.setLanguage("DUTCH");
        value.setPolicyUUID("939c5211-b5d5-4e4a-a20a-4c1d2c313bc2");

        communicationResponseObj.setValue(value);
  
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
