package com.example.syfall;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Backend implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DokumentRep dokumentRepo;

	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			HttpServletRequest req) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return;
		}

		try {

			String titel = req.getParameter("titel");
			String status = req.getParameter("status");
			String zugewiesenAn = req.getParameter("zugewiesenAn");

			byte[] bytes = file.getBytes();

			Dokumente dokument = new Dokumente();
			dokument.setName(titel);
			dokument.setGesehen(0);
			dokument.setStatus(status);
			dokument.setZugewiesen(zugewiesenAn);
			dokument.setDatum(new Date());
			dokument.setUploadVon("Benjamin");
			dokument.setDokument(bytes);
			dokument.setDokumentenTyp(file.getContentType());

			dokumentRepo.save(dokument);

			System.out.println("Erfolgreich");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/all")
	public List<Dokumente> getAllUsers() {
		return dokumentRepo.findAll();
	}

}
