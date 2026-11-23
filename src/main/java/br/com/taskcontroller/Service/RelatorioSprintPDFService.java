package br.com.taskcontroller.Service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.util.Locale;

@Service
public class RelatorioSprintPDFService {

    public byte[] gerarPDF(List<RelatorioSprintDTO> sprints) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat formatoPorc = new DecimalFormat(
                "0.00",
                DecimalFormatSymbols.getInstance(
                        Locale.forLanguageTag("pt-BR")
                )
        );

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {

            Document document = new Document(PageSize.A4.rotate());

            PdfWriter.getInstance(document, output);
            document.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);

            Paragraph cabecalho = new Paragraph("TaskController 1.0 - Relatório Gerencial de Sprints", titulo);

            cabecalho.setAlignment(Element.ALIGN_CENTER);
            cabecalho.setSpacingAfter(20);

            document.add(cabecalho);

            PdfPTable tabela = new PdfPTable(10);
            tabela.setWidthPercentage(100);

            String[] colunas = {
                    "ID", "Sprint", "Início", "Fim",
                    "Status", "Estórias", "Tarefas",
                    "Estimadas", "Realizadas", "Progresso"
            };

            for (String coluna : colunas) {
                PdfPCell celula = new PdfPCell(
                        new Phrase(coluna)
                );
                celula.setBackgroundColor(Color.LIGHT_GRAY);
                celula.setPadding(5);
                tabela.addCell(celula);
            }

            for (RelatorioSprintDTO sprint : sprints) {
                tabela.addCell(String.valueOf(sprint.idsprint()));
                tabela.addCell(sprint.descsprint());
                tabela.addCell(sprint.dtiniciosprint().format(formatoData));
                tabela.addCell(sprint.dtfinalsprint().format(formatoData));
                tabela.addCell(sprint.descstatus());
                tabela.addCell(String.valueOf(sprint.contEstorias()));
                tabela.addCell(String.valueOf(sprint.contTarefas()));
                tabela.addCell(sprint.totalHorasEstimadas60());
                tabela.addCell(sprint.totalHorasRealizadas60());
                tabela.addCell(formatoPorc.format(sprint.progresso()) + "%");
            }

            document.add(tabela);
            document.close();

            return output.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao gerar relatório PDF de Sprints", e
            );
        }
    }
}
