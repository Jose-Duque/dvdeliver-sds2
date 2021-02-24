import './styles.css';
import { ReactComponent as YoutubeIcon } from './youtube.svg';
import { ReactComponent as InstagranIcon} from './instagram.svg';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';

const Footer = () => (
  <footer className="main-footer">
    App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
    <div className="footer-icons">
      <a href="#"> <YoutubeIcon/> </a>
      <a href="#"> <InstagranIcon/> </a>
      <a href="#"> <LinkedinIcon/> </a>
    </div>
  </footer>
);

export default Footer;