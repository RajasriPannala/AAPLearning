package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnService;
import com.bourntec.aaplearning.modules.returnmanagement.v1.util.Constants;

/**
 * @author Rohini P M
 *
 */
@Service
public class ReturnServiceImpl implements ReturnService{
	Logger logger = LoggerFactory.getLogger(ReturnServiceImpl.class);
	@Autowired
	ReturnRepository returnRepository;
	
	RestTemplate restTemplate;

		
	/**
	 *
	 */
	@Override
	public ReturnResponseDTO save(ReturnRequestDTO returnRequestDTO) {
	ReturnResponseDTO retresDTO=new ReturnResponseDTO();

	Return returnValue = returnRequestDTO.convertToModel();
	returnValue.setStatus(Constants.ACTIVE);
	returnValue = returnRepository.save(returnValue);

	retresDTO.setPayload(returnValue);
	retresDTO.setResponsemessage("Data save sucessfully");
	retresDTO.setStatus("Success");
	logger.info("data saved successfully");
	return retresDTO;
	}

	
	public ReturnResponseDTO deleteById(Integer id) {
		ReturnResponseDTO returnResponseDTO = new ReturnResponseDTO();

	if (returnRepository.existsById(id) == true) {
		returnRepository.deleteById(id);
		returnResponseDTO.setResponsemessage("Deleted successfully");

		returnResponseDTO.setStatus("Success");
		logger.info("data deleted successfully");
	return returnResponseDTO;
	} else

		returnResponseDTO.setResponsemessage("Data not found");
	returnResponseDTO.setStatus("Failure");
	logger.info("data not found");
	return returnResponseDTO;


	}
	/**
	 *
	 */
	public ReturnResponseDTO updateById(Integer id, ReturnRequestDTO returnRequestDTO) {
		ReturnResponseDTO retresDTO=new ReturnResponseDTO();
		Optional<Return> returnOptional = returnRepository.findById(id);
		if (returnOptional.isPresent()) {
			Return foundReturn = returnOptional.orElseThrow(() -> null);
			
			returnRequestDTO.setReturnId(id);
			Return returnManagement= returnRequestDTO.convertToModel(foundReturn);
			foundReturn.setReturnId(id);
			//Return returnManagements= returnRequestDTO.convertToModel();
			
			//returnManagement.setReturnId(id);
			
			//Return existingreturnManagement = returnOptional.get();


		
		returnManagement.setReturnId(id);
		returnRepository.save(returnManagement);
		retresDTO.setPayload(returnManagement);
		retresDTO.setResponsemessage("Data updated sucessfully");
		retresDTO.setStatus("Sucess");
		logger.info("data updated successfully");
		return retresDTO;
		} else
		{
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		logger.info("id is invalid");
		return retresDTO;
		}

	}
	
	
	
	@Override
	public ReturnResponseDTO findById(int id) throws Exception {

	ReturnResponseDTO retresDTO=new ReturnResponseDTO();
	Optional<Return> returnOptional=returnRepository.findById(id);
	if(returnOptional.isPresent()) {

	retresDTO.setPayload(returnOptional.get());
	retresDTO.setResponsemessage(" data got sucessfully");
	retresDTO.setStatus("Success");
	logger.info("Successfull");
	return retresDTO;

	}
	else {
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		logger.info("failed");
		return retresDTO;
	}
	}


	
	
//	@Override
//	public String FindByRetAmt(int id) {
//
//		Optional<Return> returnOptional = returnRepository.findById(id);
//		if (returnOptional.isPresent()) {
//			int retAmnt = returnOptional.get().getRetAmt();
//			String category = null;
//			if (retAmnt < 2)
//				category = "below";
//			else if (retAmnt < 5)
//				category = "above";
//			else if (retAmnt < 10)
//				category = "high";
//			else
//				category = "equal";
//			return category;
//		} else {
//			throw new RecordNotFoundException("Record not found");
//		}
//		
//	
//	}
	@Override
    public List<Return> listAll() 
	{
        // TODO Auto-generated method stub
         return returnRepository.findAll(Sort.by("returnId").ascending());
	}
		private XSSFWorkbook workbook;
        private XSSFSheet sheet;
        private List<Return> listUsers;
public ReturnServiceImpl(List<Return> listUsers) 
{
         this.listUsers = listUsers;
         workbook = new XSSFWorkbook();
 }


        private void writeHeaderLine()
        {
            sheet = workbook.createSheet("Users");
            Row row = sheet.createRow(0);
            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight(16);
            style.setFont(font);

            createCell(row, 0, "Return Id", style);      
            createCell(row, 1, "Status", style);       
            createCell(row, 2, "Cust Id", style);    
            createCell(row, 3, "Description", style);
            createCell(row, 4, "Invoice Id", style);
            createCell(row, 5, "Item Code", style);
            createCell(row, 6, "Item Count", style);
            createCell(row, 7, "Quantity", style);

        }

        private void createCell( Row row, int columnCount, Object value, CellStyle style) 
        {
            sheet.autoSizeColumn(columnCount);
            Cell cell = row.createCell(columnCount);
            if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof String) {
                cell.setCellValue((String) value);
            }else if (value instanceof String) {
                cell.setCellValue((String) value);
            }else if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            }else if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            }else if (value instanceof String) {
                cell.setCellValue((String) value);
            }else if (value instanceof String) {
                cell.setCellValue((String) value);
            }else {
                cell.setCellValue((String) value);
            }
            cell.setCellStyle(style);
        }

        private void writeDataLines() {
            int rowCount = 1;

            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontHeight(14);
            style.setFont(font);

            for (Return user : listUsers) {
                Row row = sheet.createRow(rowCount++);
                int columnCount = 0;

                createCell(row, columnCount++, user.getReturnId(), style);
                createCell(row, columnCount++, user.getStatus(), style);
                createCell(row, columnCount++, user.getCustId(), style);
                createCell(row, columnCount++, user.getDescription(), style);
                createCell(row, columnCount++, user.getInvoiceId(), style);
                createCell(row, columnCount++, user.getItemCode(), style);
                createCell(row, columnCount++, user.getItemCount(), style);
                createCell(row, columnCount++, user.getQty(), style);

            }
        }

        public void export(HttpServletResponse response) throws IOException {
            writeHeaderLine();
            writeDataLines();

            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();

            outputStream.close();

        }


		@Override
		public void downloadAsCsv() {
			// TODO Auto-generated method stub
			
		}

}

	


