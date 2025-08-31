import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.ViewHolder> {

    private List<Entry> entryList;

    public EntryAdapter(List<Entry> entryList) {
        this.entryList = entryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_entry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Entry entry = entryList.get(position);
        holder.descText.setText(entry.getDescription());
        holder.amountText.setText(String.format("$%.2f", entry.getAmount()));
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView descText, amountText;

        public ViewHolder(View view) {
            super(view);
            descText = view.findViewById(R.id.entry_desc);
            amountText = view.findViewById(R.id.entry_amount);
        }
    }
}
