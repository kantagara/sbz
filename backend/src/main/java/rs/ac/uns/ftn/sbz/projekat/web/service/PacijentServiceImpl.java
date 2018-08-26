package rs.ac.uns.ftn.sbz.projekat.web.service;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Lek;

@Service
public class PacijentServiceImpl  implements PacijentService{
    @Override
    public boolean jeAlergicanNaLek(Lek lek) {
        return false;
    }
}
