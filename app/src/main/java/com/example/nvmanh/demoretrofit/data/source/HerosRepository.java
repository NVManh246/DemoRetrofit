package com.example.nvmanh.demoretrofit.data.source;

public class HerosRepository implements HerosDataSource.HerosRemoteDataSource{

    private static HerosRepository sInstance;
    private HerosDataSource.HerosRemoteDataSource mRemoteDataSource;

    private HerosRepository(HerosDataSource.HerosRemoteDataSource remoteDataSource){
        mRemoteDataSource = remoteDataSource;
    }

    public static HerosRepository getInstance(HerosDataSource.HerosRemoteDataSource remoteDataSource){
        if(sInstance == null){
            sInstance = new HerosRepository(remoteDataSource);
        }
        return sInstance;
    }

    @Override
    public void getHero(int id, HerosDataSource.OnCompleteListener callBack) {
        mRemoteDataSource.getHero(id, callBack);
    }

    @Override
    public void getHeros(HerosDataSource.OnCompleteListener callback) {
        mRemoteDataSource.getHeros(callback);
    }

    @Override
    public void searchHeros(String key, HerosDataSource.OnCompleteListener callback) {
        mRemoteDataSource.searchHeros(key, callback);
    }
}
