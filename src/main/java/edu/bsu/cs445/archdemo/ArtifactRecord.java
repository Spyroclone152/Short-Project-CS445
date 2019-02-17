package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

    static ArtifactRecord withTitle(String title) {
        ArtifactRecord record = new ArtifactRecord();
        record.title = Preconditions.checkNotNull(title);
        return record;
    }

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Title") //the green is what the actual element is in the fxml
    private String title;

    @XmlElement(name="Subject_LCSH") //the green is what the actual element is in the fxml
    private String artworkSubject;

    @XmlElement(name="Period_Style") //the green is what the actual element is in the fxml
    private String periodStyle;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="CONTENTdm_File_Name")
    private String fileName;

    String getTitle() { return title; }

    String getFileName() { return fileName; }

    String getArtworkSubject() { return artworkSubject; }

    String getPeriodStyle() { return periodStyle; }
}
