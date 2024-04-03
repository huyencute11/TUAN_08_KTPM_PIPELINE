package invoice.core.entities;

import invoice.core.InvoiceInfo;

public interface IMessage {
    InvoiceInfo getInvoiceInfo();
    void setInvoiceInfo(InvoiceInfo invoiceInfo);
    String getFileContent();
    void setFileContent(String fileContent);
}
