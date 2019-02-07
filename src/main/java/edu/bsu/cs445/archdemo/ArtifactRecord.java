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
    @XmlElement(name="Title")
    private String title;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="CONTENTdm_File_Name")
    private String fileName;

    String getTitle() {
        return title;
    }

    String getFileName() { return fileName; }
}
