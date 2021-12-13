package com.example.mobile_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewConfig {
    private Context mContext;
    private UserAdapter mUserAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Professionnel> users, List<String> keys){
        mContext=context;
        mUserAdapter=new UserAdapter( users,keys );
        recyclerView.setLayoutManager( new LinearLayoutManager( context ) );
        recyclerView.setAdapter( mUserAdapter );


    }
    class UserItemView extends RecyclerView.ViewHolder {

        private TextView mnom;
        private TextView mprenom;
        private TextView mville;
        private TextView mtele;

        private String key;
        public UserItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate( R.layout.users_list_item,parent,false ));
            mnom=(TextView) itemView.findViewById(R.id.nom_textview);
            mprenom=(TextView) itemView.findViewById(R.id.prenom_textview);
            mville=(TextView) itemView.findViewById(R.id.ville_textview);
            mtele=(TextView) itemView.findViewById(R.id.tele_textview);

        }
        public void bund(Professionnel user, String key){
            mnom.setText( user.getNom() );
            mprenom.setText( user.getPrenom() );
            mville.setText( user.getVille() );
            mtele.setText( user.getTele() );
            this.key=key;

        }
    }

    class UserAdapter extends RecyclerView.Adapter<UserItemView>{
    private List<Professionnel> mUserlist;
    private List<String> mkey;

    public UserAdapter(List<Professionnel> mlist, List<String> mkeys)
    {
        this.mUserlist=mlist;
        this.mkey=mkeys;

    }

        @Override
        public UserItemView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserItemView(parent);
        }

        @Override
        public void onBindViewHolder(UserItemView holder, int position) {
        holder.bund( mUserlist.get( position ),mkey.get( position ) );
        }

        @Override
        public int getItemCount() {
            return mUserlist.size();
        }
    }

}
