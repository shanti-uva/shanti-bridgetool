package edu.virginia.shanti.om.bridge.web;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.util.SiteAliasMapping;
import flexjson.JSONSerializer;

@RooWebScaffold(path = "sitealiases", formBackingObject = SiteAlias.class)
@RequestMapping("/sitealiases")
@Controller
public class SiteAliasController {

	@RequestMapping(value = "/listMappings", method = RequestMethod.GET)
	@ResponseBody
	public Object listAliasServiceMappings() {
		EntityManager em = SiteAlias.entityManager();
		Query q = em
				.createQuery(
						"SELECT b.remoteName, b.localContext, b.siteAlias.alias as alias FROM Bridge b join b.siteAlias");

		List resultList = q.getResultList();

		List<SiteAliasMapping> mappings = new LinkedList<SiteAliasMapping>();
		for (Object resultRow : resultList) {

			String remoteName = (String) ((Object[]) resultRow)[0];
			String localContext = (String) ((Object[]) resultRow)[1];
			String alias = (String) ((Object[]) resultRow)[2];

			mappings.add(new SiteAliasMapping(remoteName, localContext, alias));

		}

		return new JSONSerializer().exclude("*.class").serialize(mappings);
	}

}
