package pl.net.bluesoft.rnd.processtool.model.config;


import pl.net.bluesoft.rnd.processtool.model.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pt_setting")
public class ProcessToolSetting extends PersistentEntity {
    @Column(name="key_")
	private String key;
    @Column(name="value_")
	private String value;
	private String description;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
