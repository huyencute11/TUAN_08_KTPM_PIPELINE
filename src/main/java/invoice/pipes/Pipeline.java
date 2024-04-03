package invoice.pipes;

import invoice.core.entities.IFilter;
import invoice.core.entities.IMessage;


import java.util.List;

public class Pipeline extends PipelineBase<IMessage> {
    public Pipeline(List<IFilter<IMessage>> filters) {
        filters.forEach(this::RegisterFilter);
    }
}
