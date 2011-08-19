package edu.virginia.shanti.om.bridge.web;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
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
				.createQuery("SELECT b.remoteName, b.localContext, b.siteAlias.alias as alias FROM Bridge b join b.siteAlias");
		return new JSONSerializer().exclude("*.class").serialize(
				q.getResultList());
	}

}
